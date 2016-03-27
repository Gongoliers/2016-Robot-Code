package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LowerKickerToRestPosition extends Command {

	public LowerKickerToRestPosition() {
		requires(Robot.kicker);
	}

	@Override
	protected void initialize() {
//		if (Robot.auto) {
//			if (Robot.camera.targetGoal.isGoal())
//				Robot.kicker.down();
//		} else {
			Robot.kicker.down();
//		}
		setTimeout(0.6);
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return isTimedOut(); // Robot.kicker.isAtRestPosition();
	}

	@Override
	protected void end() {
		Robot.kicker.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
