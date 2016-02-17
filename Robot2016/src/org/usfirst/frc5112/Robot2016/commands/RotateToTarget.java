
package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5112.Robot2016.Robot;

/**
 *
 */
public class RotateToTarget extends Command {

	public RotateToTarget() {
		requires(Robot.driveTrain);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.driveTrain.rotateCW(Robot.camera.targetGoal.getCenterX() * 0.45);
	}

	protected boolean isFinished() {
		return Robot.camera.targetGoal.isCenteredHorizontally() && Robot.camera.targetGoal.isGoal();
	}

	protected void end() {
		Robot.driveTrain.stop();
	}

	protected void interrupted() {
		end();
	}
}
