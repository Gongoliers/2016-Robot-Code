package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc5112.Robot2016.Robot;
import org.usfirst.frc5112.Robot2016.RobotMap;

public class CalibrateIntake extends Command {

	public CalibrateIntake() {
		requires(Robot.intake);
	}

	protected void initialize() {
		Robot.intake.setBarSpeed(-1);
		setTimeout(0.6);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		if(isTimedOut()){
			Robot.intake.setFreeCurrent(Robot.pdp.getCurrent(RobotMap.pdpIntakePort));
		}
		return isTimedOut();
	}

	protected void end() {
		Robot.intake.setBarSpeed(0);
	}

	protected void interrupted() {
		end();
	}
}
