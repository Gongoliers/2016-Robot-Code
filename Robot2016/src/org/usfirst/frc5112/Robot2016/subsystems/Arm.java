package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.RobotMap;
import org.usfirst.frc5112.Robot2016.commands.MoveArmToPosition;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends PIDSubsystem {

	private final SpeedController armMotor = RobotMap.armMotor;
	private final Encoder armEncoder = RobotMap.armEncoder;

	public static final int UP_POSITION = 0;
	public static final double DEGREES_PER_PULSE = 360 / 497.0;
	public static final int DOWN_POSITION = 500;

	public Arm() {
		super("Arm", 0.02, 0, 0.01);
		setAbsoluteTolerance(5);
		getPIDController().setContinuous(false);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new MoveArmToPosition(UP_POSITION));
	}

	public void lower(double speed) {
		set(-speed);

	}

	public void raise(double speed) {
		set(speed);
	}

	public void set(double speed) {
		armMotor.set(speed);
		SmartDashboard.putNumber("Arm Angle", returnPIDInput());
	}

	public void stop() {
		armMotor.set(0);
	}

	public boolean isUp() {
		return returnPIDInput() <= UP_POSITION;
	}

	public boolean isDown() {
		return returnPIDInput() >= DOWN_POSITION;
	}

	@Override
	protected double returnPIDInput() {
		return armEncoder.getDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		set(output);
	}
}
