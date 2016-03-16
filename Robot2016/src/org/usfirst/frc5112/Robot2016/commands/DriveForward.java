package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {
	
	private double speed;

	public DriveForward(double time) {
		super(time);
		requires(Robot.driveTrain);
		speed = 0.7;
	}
	
	public DriveForward(double time, double speed) {
		super(time);
		requires(Robot.driveTrain);
		this.speed = speed;
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.driveTrain.forward(speed);
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
