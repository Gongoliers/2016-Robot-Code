package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopFlywheel extends Command{

	@Override
	protected void initialize() {
		Robot.shooter.stopFlyWheel();
		System.out.println("Stop flywheel init");

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
		System.out.println("Stop flywheel end");

	}

	@Override
	protected void interrupted() {
		
	}

}
