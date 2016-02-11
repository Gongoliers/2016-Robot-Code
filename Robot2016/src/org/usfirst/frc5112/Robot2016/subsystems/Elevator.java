package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

	private final SpeedController elevatorMotor = RobotMap.elevatorMotor;
	private final Encoder elevatorEncoder = RobotMap.elevatorEncoder;

	private static final int REST_POSITION_ENCODER_COUNT = 0;
	private static final int ELEVATED_POSITION_ENCODER_COUNT = 100;

	@Override
	protected void initDefaultCommand() {

	}

	public boolean isAtElevatedPosition() {
		return elevatorEncoder.get() >= ELEVATED_POSITION_ENCODER_COUNT;
	}

	public boolean isAtRestPosition() {
		return elevatorEncoder.get() <= REST_POSITION_ENCODER_COUNT;
	}

	public void up() {
		elevatorMotor.set(1.0);
	}

	public void down() {
		elevatorMotor.set(-1.0);
	}

	public void stop() {
		elevatorMotor.set(0);
	}

}
