package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;

public class CancelCommand extends Command {

	private Command cancelCommand;

	public CancelCommand(Command command) {
		cancelCommand = command;
	}

	@Override
	protected void initialize() {
		cancelCommand.cancel();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
