
package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5112.Robot2016.Robot;

/**
 *
 */
public class RotateToTarget extends Command {

	private double TARGET_X_POSITION_THRESHOLD = 0.1;

	public RotateToTarget() {
		requires(Robot.driveTrain);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.driveTrain.rotateCW(Robot.camera.targetGoal.centerX);
	}

	protected boolean isFinished() {
		return Math.abs(Robot.camera.targetGoal.centerX) >= TARGET_X_POSITION_THRESHOLD
				&& Robot.camera.targetGoal.isGoal;
	}

	protected void end() {
		Robot.driveTrain.stop();
	}

	protected void interrupted() {
		end();
	}
}
