package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5112.Robot2016.Robot;

public class RetractScaler extends Command {

	public RetractScaler() {

		requires(Robot.scaler);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.scaler.retract(0.5);
	}

	protected boolean isFinished() {
		return false;//Robot.scaler.isFullyRetracted();
	}

	protected void end() {
		Robot.scaler.stop();
	}

	protected void interrupted() {
		end();
	}
}
