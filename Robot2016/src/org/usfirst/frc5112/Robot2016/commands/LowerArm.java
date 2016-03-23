package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LowerArm extends Command {


	public LowerArm() {
		requires(Robot.obstacleMover);
	}

	@Override
	protected void initialize() {
		setTimeout(2.8);
	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		Robot.obstacleMover.stopBar();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
