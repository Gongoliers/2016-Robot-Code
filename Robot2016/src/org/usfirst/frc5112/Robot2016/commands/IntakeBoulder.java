package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5112.Robot2016.Robot;
import org.usfirst.frc5112.Robot2016.RobotMap;

/**
 * This controls Victor
 */
public class IntakeBoulder extends Command {

	public IntakeBoulder() {
		requires(Robot.intake);
	}

	protected void initialize() {
		Robot.intake.setBarSpeed(-1);
		setTimeout(3);
	}

	protected void execute() {
//		System.out.println("Intake: " + Robot.pdp.getCurrent(3));
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
