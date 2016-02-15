package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinUpFlywheel extends Command {

	@Override
	protected void initialize() {
		setTimeout(3);
	}

	@Override
	protected void execute() {
		Robot.shooter.spinFlyWheel(-0.75);
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
		Robot.shooter.stopFlyWheel();
	}

}
