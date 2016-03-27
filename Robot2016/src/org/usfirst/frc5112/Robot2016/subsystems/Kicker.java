package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Kicker extends Subsystem {

	private final SpeedController elevatorMotor = RobotMap.elevatorMotor;

	public static final int REST_POSITION = 0;
	public static final int ELEVATED_POSITION = 100;

	@Override
	protected void initDefaultCommand() {
	}
	
	public void up() {
		elevatorMotor.set(-0.5);
	}

	public void down() {
		elevatorMotor.set(0.35);
	}
	
	public double get(){
		return elevatorMotor.get();
	}

	public void stop() {
		elevatorMotor.set(0);
	}

}
