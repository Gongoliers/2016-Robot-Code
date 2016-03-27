package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RotateDegrees2 extends Command {
	
	private double targetAngle;
	
	public RotateDegrees2(double targetAngle) {
		requires(Robot.driveTrain);
		this.targetAngle = Robot.gyro.getAngle() + targetAngle;
	}

	@Override
	protected void initialize() {
		Robot.driveTrain.enable();
	}

	@Override
	protected void execute() {
		Robot.driveTrain.setSetpoint(targetAngle);
	}

	@Override
	protected boolean isFinished() {
		return Robot.driveTrain.onTarget();
	}

	@Override
	protected void end() {
		Robot.driveTrain.stop();
		Robot.driveTrain.disable();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
