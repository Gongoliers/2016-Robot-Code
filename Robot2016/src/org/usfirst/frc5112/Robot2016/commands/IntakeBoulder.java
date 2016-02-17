package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5112.Robot2016.Robot;

public class IntakeBoulder extends Command {

	private boolean start;

	public IntakeBoulder() {
		requires(Robot.intake);
		start = false;
	}

	protected void initialize() {
		Robot.intake.setBarSpeed(-1);
		setTimeout(4);
	}

	protected void execute() {
		SmartDashboard.putNumber("Intake Current", Robot.pdp.getCurrent(4));
		System.out.println(Robot.pdp.getCurrent(4));
		if (!start && Robot.pdp.getCurrent(4) > 5) {
			start = true;
		}
		if (start && Robot.pdp.getCurrent(4) < 4) {
			System.out.println("Done!");
		}
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
