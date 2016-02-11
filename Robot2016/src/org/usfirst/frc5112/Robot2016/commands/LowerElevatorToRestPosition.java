package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LowerElevatorToRestPosition extends Command {

	public LowerElevatorToRestPosition() {
		requires(Robot.elevator);
	}

	@Override
	protected void initialize() {
		Robot.elevator.down();
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return Robot.elevator.isAtRestPosition();
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
