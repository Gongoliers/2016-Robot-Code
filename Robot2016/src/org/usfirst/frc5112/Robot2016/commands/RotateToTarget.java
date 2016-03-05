
package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc5112.Robot2016.PID;
import org.usfirst.frc5112.Robot2016.Robot;

/**
 *
 */
public class RotateToTarget extends Command {

	private double kp = 0.86;
	private double ki = 0.2;
	private double kd = 0.25;
	private double threshold =  0.02; //0.005; 
	private double targetPosition = -0.12;

	private PID pidController;

	public RotateToTarget() {
		requires(Robot.driveTrain);
		setTimeout(4);
	}

	protected void initialize() {
		pidController = new PID(kp, ki, kd, threshold);
		LocateTarget.locatingTarget = true;
	}

	protected void execute() {
		double pidOutput = pidController.getOutput(Robot.camera.targetGoal.getCenterX(), targetPosition);
		Robot.driveTrain.rotateCCW(pidOutput);

	}

	protected boolean isFinished() {
		return (pidController.isAtTargetPosition(Robot.camera.targetGoal.getCenterX(), targetPosition)
				&& Robot.camera.targetGoal.isGoal()) || isTimedOut();
	}

	protected void end() {
		Robot.driveTrain.stop();
		LocateTarget.locatingTarget = false;
	}

	protected void interrupted() {
		end();
	}
}
