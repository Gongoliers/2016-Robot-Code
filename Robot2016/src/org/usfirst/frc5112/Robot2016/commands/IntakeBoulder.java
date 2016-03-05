package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5112.Robot2016.Robot;
import org.usfirst.frc5112.Robot2016.RobotMap;

public class IntakeBoulder extends Command {

	private boolean start;
	private boolean done;

	public IntakeBoulder() {
		requires(Robot.intake);
	}

	protected void initialize() {
		Robot.intake.setBarSpeed(-1);
		start = false;
		done = false;
		setTimeout(0.4);
		Robot.oi.xbox.setRumble(RumbleType.kLeftRumble, 0.75f);
		Robot.oi.xbox.setRumble(RumbleType.kRightRumble, 0.75f);
	}

	protected void execute() {
		SmartDashboard.putNumber("Intake Current", Robot.pdp.getCurrent(4));
		if (isTimedOut() && !start && Robot.pdp.getCurrent(RobotMap.pdpIntakePort) > Robot.intake.getFreeCurrent() + 1) {
			start = true;
		}
		if (start && Robot.pdp.getCurrent(RobotMap.pdpIntakePort) < Robot.intake.getFreeCurrent()) {
			done = true;
		}
	}

	protected boolean isFinished() {
		return done || Robot.pdp.getCurrent(RobotMap.pdpIntakePort) > 60;
	}

	protected void end() {
		Robot.intake.setBarSpeed(0);
		Robot.oi.xbox.setRumble(RumbleType.kLeftRumble, 0);
		Robot.oi.xbox.setRumble(RumbleType.kRightRumble, 0);
	}

	protected void interrupted() {
		end();
	}
}
