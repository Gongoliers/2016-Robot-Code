package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.Robot;
import org.usfirst.frc5112.Robot2016.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ObstacleMover extends Subsystem {

	private final SpeedController obstacleMoverMotor = RobotMap.obstacleMoverMotor;

	public void initDefaultCommand() {

	}

	public void lowerBar(double speed) {
		obstacleMoverMotor.set(-speed);
	}

	public void raiseBar(double speed) {
		obstacleMoverMotor.set(speed);
	}

	public void stopBar() {
		obstacleMoverMotor.set(0);
	}
}
