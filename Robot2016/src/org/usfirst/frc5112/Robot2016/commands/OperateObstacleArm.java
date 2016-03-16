package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OperateObstacleArm extends Command {
	
	public OperateObstacleArm() {
		requires(Robot.obstacleMover);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		double y = -Robot.oi.xbox.getRightY();
		Robot.obstacleMover.raiseBar(Math.copySign(1, y) * Math.pow(y, 2) * 0.75);
		

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
