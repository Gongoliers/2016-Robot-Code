package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OperateObstacleArm extends Command {

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		double y = Robot.oi.xbox.getRightY();
		if (y >= 0)
			Robot.obstacleMover.lowerBar(y);
		else
			Robot.obstacleMover.raiseBar(y);

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
