//Chris V

package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.Robot;
import org.usfirst.frc5112.Robot2016.RobotMap;
import org.usfirst.frc5112.Robot2016.commands.*;

import com.thegongoliers.input.JoystickTransformer;
import com.thegongoliers.math.Position;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class DriveTrain extends PIDSubsystem {

	private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;

	private double initialGyro = 0;

	public DriveTrain() {
		super(0.12, 0, 0.06);
		setAbsoluteTolerance(0.06);
		getPIDController().setContinuous(false);
		setOutputRange(-1, 1);
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
		Position stickPosition = new Position(stick.getX(), stick.getY());
		JoystickTransformer transformer = new JoystickTransformer();
		double newY = transformer.sensitivity(transformer.scaledRadialDeadzone(stickPosition, 0.05), 0.85).getY();
		Position rotation = new Position(stick.getZ(), 0);
		double newRotation = transformer
				.sensitivity(transformer.power(transformer.scaledRadialDeadzone(rotation, 0.1), 2), 0.75).getFirst();

		if (newRotation != 0) {
			robotDrive.arcadeDrive(newY, newRotation);
			setInitialGyro(Robot.gyro.getAngle());
		} else {
			robotDrive.arcadeDrive(newY, -0.01 * (Robot.gyro.getAngle() - initialGyro));
		}
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
