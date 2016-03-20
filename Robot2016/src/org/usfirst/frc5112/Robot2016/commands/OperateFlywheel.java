package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OperateFlywheel extends Command {

	public OperateFlywheel() {
		requires(Robot.shooter);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		double throttle = -Robot.oi.driveStick.getThrottle();
		throttle = Math.max(0, throttle);
		Robot.shooter.spinFlyWheel(-throttle);
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
