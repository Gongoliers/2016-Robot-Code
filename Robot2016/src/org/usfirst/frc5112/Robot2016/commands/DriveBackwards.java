package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveBackwards extends Command {
	
	private double speed;

	public DriveBackwards(double time) {
		super(time);
		requires(Robot.driveTrain);
		speed = 0.7;
	}
	
	public DriveBackwards(double time, double speed) {
		super(time);
		requires(Robot.driveTrain);
		this.speed = speed;
	}

	@Override
	protected void initialize() {
		Robot.gyro.reset();
	}

	@Override
	protected void execute() {
		Robot.driveTrain.reverse(speed);
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		Robot.driveTrain.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
