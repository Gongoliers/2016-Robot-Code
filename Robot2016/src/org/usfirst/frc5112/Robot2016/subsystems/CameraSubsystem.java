package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.Camera;
import org.usfirst.frc5112.Robot2016.Camera.LEDColor;
import org.usfirst.frc5112.Robot2016.Camera.Target;
import org.usfirst.frc5112.Robot2016.HighGoalRetroreflective;
import org.usfirst.frc5112.Robot2016.MicrosoftLifeCam;
import org.usfirst.frc5112.Robot2016.commands.DisplayNormalCameraImage;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraSubsystem extends Subsystem {

	private Camera camera;

	public CameraSubsystem() {
		camera = new Camera.CameraBuilder().setCamera(new MicrosoftLifeCam("cam0")).setLEDColor(LEDColor.GREEN).build();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DisplayNormalCameraImage());
	}

	public void enableTargetMode() {
		camera.enableTargetMode();
	}

	public void disableTargetMode() {
		camera.disableTargetMode();
	}

	public void display() {
		camera.display();
	}

	public Target findHighGoal() {
		return camera.findTarget(HighGoalRetroreflective.WIDTH, HighGoalRetroreflective.HEIGHT);
	}
}
