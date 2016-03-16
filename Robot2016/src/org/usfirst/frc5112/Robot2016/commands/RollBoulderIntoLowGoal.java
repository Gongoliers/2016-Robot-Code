package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RollBoulderIntoLowGoal extends Command {

	public RollBoulderIntoLowGoal() {
		super(1);
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
		Robot.intake.setBarSpeed(0.6);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	@Override
	protected void end() {
		Robot.intake.stopBar();

	}

	@Override
	protected void interrupted() {
		end();

	}

}
