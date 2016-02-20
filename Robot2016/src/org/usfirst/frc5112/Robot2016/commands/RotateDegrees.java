package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.PID;
import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateDegrees extends Command {

	private PID pidController;
	private double targetAngle;

	public RotateDegrees(double targetAngle) {
		requires(Robot.driveTrain);
		this.targetAngle = targetAngle;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.gyro.reset();
		pidController = new PID(0.6, 0, 0, 0.5);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveTrain.rotateCCW(pidController.getOutput(Robot.gyro.getAngle(), targetAngle));
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return pidController.isAtTargetPosition(Robot.gyro.getAngle(), targetAngle);
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
