package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5112.Robot2016.Robot;
import org.usfirst.frc5112.Robot2016.subsystems.Camera.CameraMode;

/**
 * Used to detect the high goal target.
 */
public class LocateTarget extends Command {

	public LocateTarget() {
		requires(Robot.camera);
	}

	protected void initialize() {
		Robot.camera.setCameraMode(CameraMode.TARGET);
	}

	protected void execute() {
		Robot.camera.locateTarget();
		SmartDashboard.putNumber("Goal Center X", Robot.camera.targetGoal.getCenterX());
//		Robot.camera.displayImage();
		CameraServer.getInstance().setImage(Robot.camera.showRetrofeflective());
	}

	protected boolean isFinished() {
		return Robot.camera.targetGoal.isCenteredHorizontally() && Robot.camera.targetGoal.isGoal();
	}

	protected void end() {
		Robot.camera.setCameraMode(CameraMode.NORMAL);
	}

	protected void interrupted() {
		end();
	}
}
