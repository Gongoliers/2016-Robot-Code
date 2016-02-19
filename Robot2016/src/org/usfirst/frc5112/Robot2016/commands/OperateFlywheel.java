package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OperateFlywheel extends Command {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.shooter.spinFlyWheel(Robot.oi.xbox.getRawAxis(5));
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.shooter.stopFlyWheel();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
