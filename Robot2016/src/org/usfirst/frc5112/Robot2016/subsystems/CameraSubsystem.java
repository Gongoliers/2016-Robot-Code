package org.usfirst.frc5112.Robot2016.subsystems;


import org.usfirst.frc5112.Robot2016.HighGoalRetroreflective;
import org.usfirst.frc5112.Robot2016.commands.DisplayNormalCameraImage;

import com.thegongoliers.input.camera.Camera;
import com.thegongoliers.input.camera.Camera.LEDColor;
import com.thegongoliers.input.camera.Camera.Target;
import com.thegongoliers.input.camera.MicrosoftLifeCam;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraSubsystem extends Subsystem {

	private Camera camera;

	public CameraSubsystem() {
		camera = new Camera.CameraBuilder().setCamera(new MicrosoftLifeCam(0)).setLEDColor(LEDColor.GREEN).build();
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
