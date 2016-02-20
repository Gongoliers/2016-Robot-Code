package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5112.Robot2016.Robot;

public class SpinIntake extends Command {


	public SpinIntake() {
		requires(Robot.intake);
	}

	protected void initialize() {
		Robot.intake.setBarSpeed(-1);
		setTimeout(4);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.intake.setBarSpeed(0);
	}

	protected void interrupted() {
		end();
	}
}
