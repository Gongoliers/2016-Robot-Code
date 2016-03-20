package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LowerArm extends Command {

	private long startTime = 0;

	public LowerArm() {
		requires(Robot.obstacleMover);
	}

	@Override
	protected void initialize() {
		setTimeout(2.8);
		startTime = System.currentTimeMillis();
	}

	@Override
	protected void execute() {
		if (!isTimedOut()) {
			if (System.currentTimeMillis() - startTime <= 350)
				Robot.obstacleMover.lowerBar(0.5);
			else
				Robot.obstacleMover.lowerBar(0.08);
		} else {
			Robot.obstacleMover.stopBar();
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
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
