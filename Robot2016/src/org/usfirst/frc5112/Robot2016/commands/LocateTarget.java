package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5112.Robot2016.Robot;

import com.thegongoliers.input.camera.Camera.Target;


/**
 * Used to detect the high goal target.
 */
public class LocateTarget extends Command {

	public static boolean locatingTarget = false;

	public static Target target;

	public LocateTarget() {
		requires(Robot.camera);
		target = new Target();
	}

	protected void initialize() {
		Robot.camera.enableTargetMode();
		locatingTarget = true;
	}

	protected void execute() {
		try {
			target = Robot.camera.findHighGoal();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		SmartDashboard.putNumber("Goal Center X", target.getCenterX());
		SmartDashboard.putNumber("Goal distance", target.getDistance());
		SmartDashboard.putNumber("Goal Angle", target.getAngle());
	}

	protected boolean isFinished() {
		return !locatingTarget;
	}

	protected void end() {
		Robot.camera.disableTargetMode();
	}

	protected void interrupted() {
		end();
	}
}
