package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5112.Robot2016.Robot;
import org.usfirst.frc5112.Robot2016.subsystems.Camera.CameraMode;

/**
 * Displays the camera image on the SmartDashboard to allow drivers to see the
 * obstacles in front of them.
 */
public class DisplayNormalCameraImage extends Command {

	public DisplayNormalCameraImage() {
		requires(Robot.camera);
	}

	protected void initialize() {
		Robot.camera.setCameraMode(CameraMode.NORMAL);
	}

	protected void execute() {
		Robot.camera.displayImage();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
