
package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5112.Robot2016.Robot;

/**
 *
 */
public class RotateToTarget extends Command {

	private double previousError;
	private double sumError;
	private double kp = 0.58;
	private double ki = 0.04;
	private double kd = 0.3;

	public RotateToTarget() {
		requires(Robot.driveTrain);
	}

	protected void initialize() {
		previousError = Robot.camera.targetGoal.getCenterX();
		sumError = 0;
	}

	protected void execute() {
		double error = Robot.camera.targetGoal.getCenterX();
		sumError += error;
		Robot.driveTrain.rotateCW(error * kp + (error - previousError) * kd + sumError * ki);
		previousError = error;
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
