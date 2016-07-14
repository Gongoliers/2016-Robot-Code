package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinUpFlywheel extends Command {

	public SpinUpFlywheel() {
		requires(Robot.shooter);
	}

	@Override
	protected void initialize() {
		setTimeout(2.8);
	}

	@Override
	protected void execute() {
		double speed = (Robot.shooter.getShooterSpeedAtDistance(LocateTarget.target.getDistance() - 1));
		Robot.shooter.spinFlyWheel(speed);
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
