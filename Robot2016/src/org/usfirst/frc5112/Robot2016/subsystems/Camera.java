// Kyle

package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.MicrosoftLifeCam;
import org.usfirst.frc5112.Robot2016.RobotMap;
import org.usfirst.frc5112.Robot2016.commands.DisplayNormalCameraImage;

import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {

	private final MicrosoftLifeCam robotCamera = RobotMap.robotCamera;
	public static double targetDistance = 0;
	public static double targetX, targetY;
	private CameraMode currentMode;

	public Camera() {
		currentMode = CameraMode.NORMAL;
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

	public double getTargetDistance() {
		double distance = robotCamera.getDistanceToTarget(0, 0, 0, 0);
		targetDistance = distance;
		return distance;
	}

	public double[] locateTargetCenter() {
		// TODO enable detection of target
		double[] aimingPoints = robotCamera.convertPixelSystemToAimingSystem(new int[] { 0, 0 },
				robotCamera.getResolution(MicrosoftLifeCam.Axis.X), robotCamera.getResolution(MicrosoftLifeCam.Axis.Y));
		targetX = aimingPoints[0];
		targetY = aimingPoints[1];
		return aimingPoints;
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

}
