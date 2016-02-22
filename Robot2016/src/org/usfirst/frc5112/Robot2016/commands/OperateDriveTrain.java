package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5112.Robot2016.Robot;

/**
 *
 */
public class OperateDriveTrain extends Command {

	public OperateDriveTrain() {

		requires(Robot.driveTrain);

	}

	protected void initialize() {
		Robot.gyro.reset();
	}

	protected void execute() {
		Robot.driveTrain.operate(Robot.oi.getDriveStick());
		SmartDashboard.putNumber("Tilt", Robot.accel.getTilt());
		SmartDashboard.putNumber("Heading", Robot.gyro.getAngle());
		SmartDashboard.putNumber("Rate of Rotation", Robot.gyro.getRate());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.driveTrain.stop();
	}

	protected void interrupted() {
		end();
	}
}
