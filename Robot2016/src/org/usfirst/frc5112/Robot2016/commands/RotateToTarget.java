
package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc5112.Robot2016.PID;
import org.usfirst.frc5112.Robot2016.Robot;

/**
 *
 */
public class RotateToTarget extends Command {

	private double kp = 0.72;
	private double ki = 0.06;
	private double kd = 0.26;
	private double threshold = 0.01;

	private PID pidController;

	public RotateToTarget() {
		requires(Robot.driveTrain);
	}

	protected void initialize() {
		pidController = new PID(kp, ki, kd, threshold);
	}

	protected void execute() {
		double pidOutput = pidController.getOutput(Robot.camera.targetGoal.getCenterX(), 0);
		Robot.driveTrain.rotateCCW(pidOutput);

	}

	protected boolean isFinished() {
		return pidController.isAtTargetPosition(Robot.camera.targetGoal.getCenterX(), 0)
				&& Robot.camera.targetGoal.isGoal();
	}

	protected void end() {
		Robot.driveTrain.stop();
		Robot.camera.getCurrentCommand().cancel();
	}

	protected void interrupted() {
		end();
	}
}
