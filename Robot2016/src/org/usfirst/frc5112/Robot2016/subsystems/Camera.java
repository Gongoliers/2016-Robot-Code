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
 * The camera subsystem of the robot which is responsible for targeting the goal
 * and allowing the driver to see.
 */
public class Camera extends Subsystem {

	/**
	 * A helper class to hold the analysis scores of the goal.
	 *
	 */
	private class Scores {
		double Area;
		double Aspect;
	};

	/**
	 * A helper class to hold the data from the particle report of the goal.
	 *
	 */
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

	/**
	 * A helper class which holds the information about a goal.
	 *
	 */
	public class Goal {
		private double centerX, centerY;
		private boolean isGoal;
		public double distance;
		private final double CENTER_X_THRESHOLD = 0.1;

		public boolean isCenteredHorizontally() {
			return Math.abs(centerX) >= CENTER_X_THRESHOLD;
		}

		public double getCenterX() {
			return centerX;
		}

		public double getCenterY() {
			return centerY;
		}

		public boolean isGoal() {
			return isGoal;
		}

		private void setCenterY(double y) {
			centerY = y;
		}

		private void setCenterX(double x) {
			centerX = x;
		}
	}

	private final MicrosoftLifeCam robotCamera = RobotMap.robotCamera;
	public Goal targetGoal;
	private CameraMode currentMode;
	private final double AREA_MIN = 0.5;
	private final double SCORE_MIN = 75.0;
	private NIVision.ParticleFilterCriteria2 criteria[] = new NIVision.ParticleFilterCriteria2[1];
	private NIVision.ParticleFilterOptions2 filterOptions = new NIVision.ParticleFilterOptions2(0, 0, 1, 1);
	private Scores scores = new Scores();

	public Camera() {
		setCameraMode(CameraMode.NORMAL);
		targetGoal = new Goal();
		criteria[0] = new NIVision.ParticleFilterCriteria2(NIVision.MeasurementType.MT_AREA_BY_IMAGE_AREA, AREA_MIN,
				100.0, 0, 0);
	}

	/**
	 * Contains the two camera modes that the camera can be in. TARGET: Used to
	 * target the goal. NORMAL: Used to allow drivers to clearly see in front of
	 * them.
	 *
	 */
	public static enum CameraMode {
		TARGET, NORMAL
	}

	/**
	 * By default, display the image that the drivers would see.
	 */
	public void initDefaultCommand() {
		setDefaultCommand(new DisplayNormalCameraImage());
	}

	/**
	 * Display the current image to the SmartDashboard.
	 */
	public void displayImage() {
		robotCamera.displayOnCameraServer();
	}

	/**
	 * Get the current image from the camera.
	 * 
	 * @return The current Image from the camera, in the current camera mode.
	 */
	public Image getImage() {
		return robotCamera.getCurrentFrame();
	}

	/**
	 * Locates the high goal.
	 * 
	 * @return A Goal object representing the current, most prominent high goal.
	 */
	public Goal locateTarget() {
		Goal goal = findGoal(filterRetroreflective());
		targetGoal = goal;
		return goal;
	}

	/**
	 * Activates target mode.
	 */
	private void enableTargetMode() {
		robotCamera.setBrightness(0);
		robotCamera.setExposureManual(0);
	}

	/**
	 * Activates normal mode.
	 */
	private void enableNormalMode() {
		robotCamera.setBrightness(50);
		robotCamera.setExposureAuto();
	}

	/**
	 * Sets the current mode of the camera.
	 * 
	 * @param mode
	 *            The CameraMode that the camera should enter.
	 */
	public void setCameraMode(CameraMode mode) {
		currentMode = mode;
		if (mode.equals(CameraMode.NORMAL))
			enableNormalMode();
		else
			enableTargetMode();
	}

	/**
	 * Gets the current camera mode.
	 * 
	 * @return The CameraMode that the camera is currently in.
	 */
	public CameraMode getCurrentMode() {
		return currentMode;
	}

	/**
	 * Filters the image to only display the retroreflective tape.
	 * 
	 * @return A binary image where the retroreflective tape is white.
	 */
	private Image filterRetroreflective() {
		Image binaryFrame = NIVision.imaqCreateImage(ImageType.IMAGE_U8, 0);
		NIVision.imaqColorThreshold(binaryFrame, getImage(), 255, NIVision.ColorMode.HSV,
				HighGoalRetroreflective.HUE_RANGE, HighGoalRetroreflective.SAT_RANGE,
				HighGoalRetroreflective.VAL_RANGE);
		NIVision.imaqParticleFilter4(binaryFrame, binaryFrame, criteria, filterOptions, null);
		return binaryFrame;
	}

	/**
	 * Finds the high goal in an image.
	 * 
	 * @param binaryFilteredImage
	 *            The retroreflective filtered image as a binary frame.
	 * @return A Goal object representing the current and most prominent goal or
	 *         null if no goal is detected.
	 */
	private Goal findGoal(Image binaryFilteredImage) {
		ParticleReport goalParticleReport = generateParticleReport(binaryFilteredImage);
		if (goalParticleReport == null)
			return null;
		scores.Aspect = getAspectScore(goalParticleReport);
		scores.Area = getAreaScore(goalParticleReport);
		Goal locatedGoal = new Goal();
		locatedGoal.isGoal = scores.Aspect > SCORE_MIN && scores.Area > SCORE_MIN;
		locatedGoal.distance = computeDistance(binaryFilteredImage, goalParticleReport);
		double rawX = (goalParticleReport.BoundingRectLeft + goalParticleReport.BoundingRectRight) / 2;
		double rawY = (goalParticleReport.BoundingRectBottom + goalParticleReport.BoundingRectTop) / 2;
		double[] aimingPoints = robotCamera.convertPixelSystemToAimingSystem(new int[] { (int) rawX, (int) rawY },
				robotCamera.getResolution(MicrosoftLifeCam.Axis.X), robotCamera.getResolution(MicrosoftLifeCam.Axis.Y));
		locatedGoal.setCenterX(aimingPoints[0]);
		locatedGoal.setCenterY(aimingPoints[1]);
		return locatedGoal;

	}

	/**
	 * Generates a particle report for the largest particle in the image.
	 * 
	 * @param binaryFilteredImage
	 *            A binary filtered image.
	 * @return The ParticleReport of the largest object or null if no particles
	 *         are detected.
	 */
	private ParticleReport generateParticleReport(Image binaryFilteredImage) {
		int numParticles = NIVision.imaqCountParticles(binaryFilteredImage, 1);
		if (numParticles > 0) {
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
			return particles.elementAt(0);
		}
		return null;
	}

	/**
	 * Gets the area score of a goal.
	 * 
	 * @param report
	 *            The particle report of the most prominent object of interest.
	 * @return The area score of the 'goal' on a scale of 0 to 100.
	 */
	private double getAreaScore(ParticleReport report) {
		double boundingArea = (report.BoundingRectBottom - report.BoundingRectTop)
				* (report.BoundingRectRight - report.BoundingRectLeft);

		return ratioToScore(HighGoalRetroreflective.BOUNDING_RECTANGLE_AREA / HighGoalRetroreflective.AREA * report.Area
				/ boundingArea);
	}

	/**
	 * Converts a raw ratio to a score from 0 to 100.
	 * 
	 * @param A
	 *            ratio of the actual * theoretical^-1 values.
	 * @return The ratio score of a method on a scale of 0 to 100.
	 */
	private double ratioToScore(double ratio) {
		return (Math.max(0, Math.min(100 * (1 - Math.abs(1 - ratio)), 100)));
	}

	/**
	 * Computes the distance to the goal.
	 * 
	 * @param image
	 *            The current image from the camera.
	 * @param report
	 *            The ParticleReport of the most prominent 'goal'.
	 * @return The distance to the goal in meters .
	 */
	private double computeDistance(Image image, ParticleReport report) {
		double normalizedWidth;
		NIVision.GetImageSizeResult size;

		size = NIVision.imaqGetImageSize(image);
		normalizedWidth = 2 * (report.BoundingRectRight - report.BoundingRectLeft) / size.width;

		return HighGoalRetroreflective.WIDTH
				/ (normalizedWidth * 12 * Math.tan(robotCamera.getViewAngle() * Math.PI / (180 * 2)));
	}

	/**
	 * Gets the aspect score of a goal.
	 * 
	 * @param report
	 *            The particle report of the most prominent object of interest.
	 * @return The score score of the 'goal' on a scale of 0 to 100.
	 */
	private double getAspectScore(ParticleReport report) {
		return ratioToScore(HighGoalRetroreflective.HEIGHT / HighGoalRetroreflective.WIDTH
				* (report.BoundingRectRight - report.BoundingRectLeft)
				/ (report.BoundingRectBottom - report.BoundingRectTop));
	}

}
