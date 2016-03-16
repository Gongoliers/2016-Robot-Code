package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PrepareBoulderForLowGoal extends Command {

	public PrepareBoulderForLowGoal() {
		super(0.35);
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
		Robot.intake.setBarSpeed(0.6);
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
		Robot.intake.stopBar();

	}

	@Override
	protected void interrupted() {
		end();
	}

}
