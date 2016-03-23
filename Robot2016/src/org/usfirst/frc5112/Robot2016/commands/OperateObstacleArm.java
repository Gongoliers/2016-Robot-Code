package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OperateObstacleArm extends Command {
	
	public OperateObstacleArm() {
		requires(Robot.obstacleMover);
	}

	@Override
	protected void initialize() {
		Robot.obstacleMover.enable();
	}

	@Override
	protected void execute() {
		double y = Robot.oi.xbox.getRightY() * 60;
//		Robot.obstacleMover.raiseBar(Math.copySign(1, y) * Math.pow(y, 2) * 0.75);
		Robot.obstacleMover.setSetpoint(y);
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
