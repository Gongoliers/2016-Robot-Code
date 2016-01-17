// Kyle

package org.usfirst.frc5112.Robot2016.subsystems;

import java.util.Comparator;
import java.util.Vector;

import org.usfirst.frc5112.Robot2016.HighGoalRetroreflective;
import org.usfirst.frc5112.Robot2016.MicrosoftLifeCam;
import org.usfirst.frc5112.Robot2016.RobotMap;
import org.usfirst.frc5112.Robot2016.commands.DisplayNormalCameraImage;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ImageType;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {

	private class Scores {
		double Area;
		double Aspect;
	};

	private class ParticleReport implements Comparator<ParticleReport>, Comparable<ParticleReport> {
		double PercentAreaToImageArea;
		double Area;
		double BoundingRectLeft;
		double BoundingRectTop;
		double BoundingRectRight;
		double BoundingRectBottom;

		public int compareTo(ParticleReport r) {
			return (int) (r.Area - this.Area);
		}

		public int compare(ParticleReport r1, ParticleReport r2) {
			return (int) (r1.Area - r2.Area);
		}
	};

	private class Goal {
		double centerX, centerY;
		boolean isGoal;
		double distance;
	}

	private final MicrosoftLifeCam robotCamera = RobotMap.robotCamera;
	public static double targetDistance = 0;
	public static Goal targetGoal;
	private CameraMode currentMode;
	private final double AREA_MIN = 0.5;
	private final double SCORE_MIN = 75.0;
	private NIVision.ParticleFilterCriteria2 criteria[] = new NIVision.ParticleFilterCriteria2[1];
	private NIVision.ParticleFilterOptions2 filterOptions = new NIVision.ParticleFilterOptions2(0, 0, 1, 1);
	private Scores scores = new Scores();
	private Image binaryFrame;

	public Camera() {
		currentMode = CameraMode.NORMAL;
		binaryFrame = NIVision.imaqCreateImage(ImageType.IMAGE_U8, 0);
		targetGoal = new Goal();
		criteria[0] = new NIVision.ParticleFilterCriteria2(NIVision.MeasurementType.MT_AREA_BY_IMAGE_AREA, AREA_MIN,
				100.0, 0, 0);
	}

	public static enum CameraMode {
		TARGET, NORMAL
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DisplayNormalCameraImage());
	}

	public void displayImage() {
		robotCamera.displayOnCameraServer();
	}

	public Image getImage() {
		return robotCamera.getCurrentFrame();
	}

	public Goal locateTarget() {
		Goal goal = findGoal(filterRetroreflective());
		double[] aimingPoints = robotCamera.convertPixelSystemToAimingSystem(
				new int[] { (int) goal.centerX, (int) goal.centerY },
				robotCamera.getResolution(MicrosoftLifeCam.Axis.X), robotCamera.getResolution(MicrosoftLifeCam.Axis.Y));
		goal.centerX = aimingPoints[0];
		goal.centerY = aimingPoints[1];
		targetGoal = goal;
		return goal;
	}

	private void enableTargetMode() {
		robotCamera.setBrightness(0);
		robotCamera.setExposureManual(0);
	}

	private void enableNormalMode() {
		robotCamera.setBrightness(50);
		robotCamera.setExposureAuto();
	}

	public void setCameraMode(CameraMode mode) {
		currentMode = mode;
		if (mode.equals(CameraMode.NORMAL))
			enableNormalMode();
		else
			enableTargetMode();
	}

	public CameraMode getCurrentMode() {
		return currentMode;
	}

	private Image filterRetroreflective() {
		NIVision.imaqColorThreshold(binaryFrame, getImage(), 255, NIVision.ColorMode.HSV,
				HighGoalRetroreflective.HUE_RANGE, HighGoalRetroreflective.SAT_RANGE,
				HighGoalRetroreflective.VAL_RANGE);
		return binaryFrame;
	}

	private Goal findGoal(Image binaryFilteredImage) {
		NIVision.imaqParticleFilter4(binaryFilteredImage, binaryFilteredImage, criteria, filterOptions, null);
		int numParticles = NIVision.imaqCountParticles(binaryFilteredImage, 1);
		if (numParticles > 0) {
			// Measure particles and sort by particle size
			Vector<ParticleReport> particles = new Vector<ParticleReport>();
			for (int particleIndex = 0; particleIndex < numParticles; particleIndex++) {
				ParticleReport par = new ParticleReport();
				par.PercentAreaToImageArea = NIVision.imaqMeasureParticle(binaryFilteredImage, particleIndex, 0,
						NIVision.MeasurementType.MT_AREA_BY_IMAGE_AREA);
				par.Area = NIVision.imaqMeasureParticle(binaryFilteredImage, particleIndex, 0,
						NIVision.MeasurementType.MT_AREA);
				par.BoundingRectTop = NIVision.imaqMeasureParticle(binaryFilteredImage, particleIndex, 0,
						NIVision.MeasurementType.MT_BOUNDING_RECT_TOP);
				par.BoundingRectLeft = NIVision.imaqMeasureParticle(binaryFilteredImage, particleIndex, 0,
						NIVision.MeasurementType.MT_BOUNDING_RECT_LEFT);
				par.BoundingRectBottom = NIVision.imaqMeasureParticle(binaryFilteredImage, particleIndex, 0,
						NIVision.MeasurementType.MT_BOUNDING_RECT_BOTTOM);
				par.BoundingRectRight = NIVision.imaqMeasureParticle(binaryFilteredImage, particleIndex, 0,
						NIVision.MeasurementType.MT_BOUNDING_RECT_RIGHT);
				particles.add(par);
			}
			particles.sort(null);

			scores.Aspect = getAspectScore(particles.elementAt(0));
			scores.Area = getAreaScore(particles.elementAt(0));
			Goal locatedGoal = new Goal();
			locatedGoal.isGoal = scores.Aspect > SCORE_MIN && scores.Area > SCORE_MIN;
			locatedGoal.distance = computeDistance(binaryFilteredImage, particles.elementAt(0));
			locatedGoal.centerX = (particles.elementAt(0).BoundingRectLeft + particles.elementAt(0).BoundingRectRight)
					/ 2;
			locatedGoal.centerY = (particles.elementAt(0).BoundingRectBottom + particles.elementAt(0).BoundingRectTop)
					/ 2;
			return locatedGoal;

		} else {
			return new Goal();
		}

	}

	private double getAreaScore(ParticleReport report) {
		double boundingArea = (report.BoundingRectBottom - report.BoundingRectTop)
				* (report.BoundingRectRight - report.BoundingRectLeft);

		return ratioToScore(HighGoalRetroreflective.BOUNDING_RECTANGLE_AREA / HighGoalRetroreflective.AREA * report.Area
				/ boundingArea);
	}

	private double ratioToScore(double ratio) {
		return (Math.max(0, Math.min(100 * (1 - Math.abs(1 - ratio)), 100)));
	}

	private double computeDistance(Image image, ParticleReport report) {
		double normalizedWidth;
		NIVision.GetImageSizeResult size;

		size = NIVision.imaqGetImageSize(image);
		normalizedWidth = 2 * (report.BoundingRectRight - report.BoundingRectLeft) / size.width;

		return HighGoalRetroreflective.WIDTH
				/ (normalizedWidth * 12 * Math.tan(robotCamera.getViewAngle() * Math.PI / (180 * 2)));
	}

	private double getAspectScore(ParticleReport report) {
		return ratioToScore(HighGoalRetroreflective.HEIGHT / HighGoalRetroreflective.WIDTH
				* (report.BoundingRectRight - report.BoundingRectLeft)
				/ (report.BoundingRectBottom - report.BoundingRectTop));

	}

}
