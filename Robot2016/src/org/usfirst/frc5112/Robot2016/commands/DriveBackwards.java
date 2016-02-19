package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveBackwards extends Command{

	@Override
	protected void initialize() {
		setTimeout(0.5);
	}

	@Override
	protected void execute() {
		Robot.driveTrain.reverse(0.5);
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
