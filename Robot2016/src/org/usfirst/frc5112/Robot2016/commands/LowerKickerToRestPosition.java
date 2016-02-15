package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LowerKickerToRestPosition extends Command {

	public LowerKickerToRestPosition() {
		requires(Robot.kicker);
	}

	@Override
	protected void initialize() {
		Robot.kicker.down();
		setTimeout(0.4);
		System.out.println("Lower kicker Init");
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
		System.out.println("Lower kicker end");
	}

	@Override
	protected void interrupted() {
		end();
	}

}
