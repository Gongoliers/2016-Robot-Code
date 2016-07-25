package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Kicker extends Subsystem {

	private final SpeedController kickerMotor = RobotMap.kickerMotor;

	@Override
	protected void initDefaultCommand() {
	}
	
	public void up() {
		kickerMotor.set(-0.5);
	}

	public void down() {
		kickerMotor.set(0.35);
	}
	
	public double get(){
		return kickerMotor.get();
	}

	public void stop() {
		kickerMotor.set(0);
	}

}
