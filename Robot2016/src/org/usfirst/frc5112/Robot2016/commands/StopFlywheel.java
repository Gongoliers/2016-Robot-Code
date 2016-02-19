package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopFlywheel extends Command {
	
	public StopFlywheel() {
		requires(Robot.shooter);
	}

	@Override
	protected void initialize() {
		Robot.shooter.stopFlyWheel();
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {

	}

}
