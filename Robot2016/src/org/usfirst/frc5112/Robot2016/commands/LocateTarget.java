package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5112.Robot2016.Robot;
import org.usfirst.frc5112.Robot2016.subsystems.Camera.CameraMode;

/**
 * Used to detect the high goal target.
 */
public class LocateTarget extends Command {
	
	public static boolean locatingTarget = false;

	public LocateTarget() {
		requires(Robot.camera);
	}

	protected void initialize() {
		Robot.camera.setCameraMode(CameraMode.TARGET);
		locatingTarget = true;
	}

	protected void execute() {
		try {
			Robot.camera.locateTarget();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SmartDashboard.putNumber("Goal Center X", Robot.camera.targetGoal.getCenterX());
		SmartDashboard.putNumber("Goal distance", Robot.camera.targetGoal.getDistance());
	}

	protected boolean isFinished() {
		return !locatingTarget;
	}

	protected void end() {
		Robot.camera.setCameraMode(CameraMode.NORMAL);
	}

	protected void interrupted() {
		end();
	}
}
