package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Kicker extends Subsystem {

	private final SpeedController elevatorMotor = RobotMap.elevatorMotor;
	private final Encoder elevatorEncoder = RobotMap.elevatorEncoder;

	public static final int REST_POSITION = 0;
	public static final int ELEVATED_POSITION = 100;

	@Override
	protected void initDefaultCommand() {
	}

	public boolean isAtElevatedPosition() {
		return elevatorEncoder.get() >= ELEVATED_POSITION;
	}

	public boolean isAtRestPosition() {
		return elevatorEncoder.get() <= REST_POSITION;
	}

	public void up() {
		elevatorMotor.set(-0.4);
	}

	public void down() {
		elevatorMotor.set(0.25);
	}
	
	public double get(){
		return elevatorMotor.get();
	}

	public void stop() {
		elevatorMotor.set(0);
	}

}
