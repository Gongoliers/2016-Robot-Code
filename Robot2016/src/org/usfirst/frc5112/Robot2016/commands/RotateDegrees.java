package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import com.thegongoliers.output.PID;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RotateDegrees extends Command {

	private PID pidController;
	private double targetAngle;
	private boolean goal = false;

	public RotateDegrees(double targetAngle) {
		requires(Robot.driveTrain);
		this.targetAngle = targetAngle;
		setTimeout(3);
	}

	public RotateDegrees() {
		requires(Robot.driveTrain);
		goal = true;
		setTimeout(4);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (goal) {
			targetAngle = LocateTarget.target.getAngle();
		}

		targetAngle += Robot.gyro.getAngle();
		pidController = new PID(0.12, 0, 0.06, 0);// RobotMap.robotCamera.getViewAngle()/2*0.02);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putNumber("Heading", Robot.gyro.getAngle());
		Robot.driveTrain.rotateCW(pidController.getOutput(Robot.gyro.getAngle(), targetAngle));
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return pidController.isAtTargetPosition(Robot.gyro.getAngle(), targetAngle) || isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
