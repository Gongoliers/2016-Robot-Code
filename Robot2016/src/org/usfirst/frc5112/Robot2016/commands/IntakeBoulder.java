package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5112.Robot2016.Robot;

public class IntakeBoulder extends Command {

	public IntakeBoulder() {
		requires(Robot.intake);
	}

	protected void initialize() {
		Robot.intake.setBarSpeed(-1);
		setTimeout(4);
	}

	protected void execute() {
		SmartDashboard.putNumber("Intake Current", Robot.pdp.getCurrent(3));
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
