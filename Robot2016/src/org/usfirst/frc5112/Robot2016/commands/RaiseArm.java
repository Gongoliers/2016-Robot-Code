package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseArm extends Command {

	public RaiseArm() {
		requires(Robot.obstacleMover);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.obstacleMover.raiseBar(0.48);
	}

	@Override
	protected boolean isFinished() {
		return Robot.obstacleMover.isBarUp();
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
