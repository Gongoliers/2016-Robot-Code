package org.usfirst.frc5112.Robot2016;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Accelerometer {
	private BuiltInAccelerometer accelerometer = RobotMap.accelerometer;

	public double getTilt() {
		double y = accelerometer.getY();
		y = Math.min(1, y);
		y = Math.max(-1, y);
		return Math.toDegrees(Math.asin(y));
	}

	public double getY() {
		return accelerometer.getY();
	}

	public double getX() {
		return accelerometer.getX();
	}

	public double getZ() {
		return accelerometer.getZ();
	}

	public void display() {
		SmartDashboard.putNumber("Accelerometer Y", getY());
	}
}
