//Chris V

package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.Robot;
import org.usfirst.frc5112.Robot2016.RobotMap;
import org.usfirst.frc5112.Robot2016.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;

	private double maxSpeed = 1.0;

	public void initDefaultCommand() {
		setDefaultCommand(new OperateDriveTrain());
	}

	/**
	 * Allows the drivetrain to be operated using a Joystick.
	 * 
	 * @param stick
	 *            The Joystick that will be used to operate the drivetrain.
	 */
	public void operate(Joystick stick) {
		double y = stick.getY();
		y = Math.max(-maxSpeed, y);
		y = Math.min(maxSpeed, y);

		robotDrive.arcadeDrive(y / 2.0, 3.0 * stick.getZ() / 4.0);
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/**
	 * Stops the drivetrain motors.
	 */
	public void stop() {
		robotDrive.drive(0, 0);
	}

	/**
	 * Moves the drivetrain forward.
	 * 
	 * @param speed
	 *            The speed of the drivetrain.
	 */
	public void forward(double speed) {
		robotDrive.drive(-speed, -0.03 * Robot.gyro.getAngle());
	}

	/**
	 * Moves the drivetrain in reverse.
	 * 
	 * @param speed
	 *            The speed of the drivetrain.
	 */
	public void reverse(double speed) {
		robotDrive.drive(speed, -0.03 * Robot.gyro.getAngle());
	}

	/**
	 * Rotate the drivetrain in a clockwise direction.
	 * 
	 * @param rotationSpeed
	 *            The speed of rotation.
	 */
	public void rotateCW(double rotationSpeed) {
		robotDrive.arcadeDrive(0, rotationSpeed);
	}

	/**
	 * Rotate the drivetrain in a counterclockwise direction.
	 * 
	 * @param rotationSpeed
	 *            The speed of the rotation.
	 */
	public void rotateCCW(double rotationSpeed) {
		robotDrive.arcadeDrive(0, -rotationSpeed);
	}

}
