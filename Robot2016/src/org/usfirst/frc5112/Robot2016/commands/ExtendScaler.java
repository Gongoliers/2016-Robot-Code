package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5112.Robot2016.Robot;

public class ExtendScaler extends Command {

	public ExtendScaler() {

		requires(Robot.scaler);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.scaler.extend(0.5);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.scaler.stop();
	}

	protected void interrupted() {
		end();
	}
}
