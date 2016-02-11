package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevateBoulderToFlywheel extends Command {

	public ElevateBoulderToFlywheel() {
		requires(Robot.elevator);
	}

	@Override
	protected void initialize() {
		Robot.elevator.up();
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return Robot.elevator.isAtElevatedPosition();
	}

	@Override
	protected void end() {
		Robot.elevator.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
