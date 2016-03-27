//Chris V

package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.Robot;
import org.usfirst.frc5112.Robot2016.RobotMap;
import org.usfirst.frc5112.Robot2016.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class DriveTrain extends PIDSubsystem {

	private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;

	private double maxSpeed = 1.0;

	private double initialGyro = 0;

	public DriveTrain() {
		super(0.12, 0, 0.06);
		setAbsoluteTolerance(0.06);
		getPIDController().setContinuous(false);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new OperateDriveTrain());
	}

	public void setInitialGyro(double angle) {
		initialGyro = angle;
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
		double rotation = stick.getZ();
		if (Math.abs(rotation) >= 0.1) {
			robotDrive.arcadeDrive(y * 0.85, 3.0 * Math.copySign(1, stick.getZ()) * Math.pow(stick.getZ(), 2) / 4.0);
			setInitialGyro(Robot.gyro.getAngle());
		} else {
			robotDrive.arcadeDrive(y * 0.85, -0.01 * (Robot.gyro.getAngle() - initialGyro));
		}
		// Math.copySign(1, y) * Math.pow(y, 2)

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

	
	@Override
	protected double returnPIDInput() {
		return Robot.gyro.getAngle();
	}
	
	@Override
	protected void usePIDOutput(double output) {
		rotateCCW(output);		
	}

}
