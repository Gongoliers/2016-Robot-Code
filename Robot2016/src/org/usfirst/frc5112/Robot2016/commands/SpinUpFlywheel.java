package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinUpFlywheel extends Command {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		setTimeout(4);
	}

	@Override
	protected void execute() {
		// Best shooting power: -0.75
		Robot.shooter.spinFlyWheel(-0.75);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.shooter.stopFlyWheel();
	}

}
