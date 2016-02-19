package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardForFiveSeconds extends Command {
	
	public DriveForwardForFiveSeconds() {
		requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
		setTimeout(5);
	}

	@Override
	protected void execute() {
		Robot.driveTrain.forward(1);
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
