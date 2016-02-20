package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseArm extends Command {

	public RaiseArm() {
		requires(Robot.obstacleMover);
	}

	@Override
	protected void initialize() {
		setTimeout(2);
	}

	@Override
	protected void execute() {
		Robot.obstacleMover.raiseBar(0.2);
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
