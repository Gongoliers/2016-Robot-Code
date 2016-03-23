package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.RobotMap;
import org.usfirst.frc5112.Robot2016.commands.MoveArmToPosition;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ObstacleMover extends Subsystem {

	private final SpeedController obstacleMoverMotor = RobotMap.obstacleMoverMotor;
	private final Encoder obstacleMoverEncoder = RobotMap.obstacleMoverEncoder;

	public static final int UP_POSITION = 0;
	public static final int DOWN_POSITION = 60;
	public static final double DEGREES_PER_PULSE = 360 / 497.0;

	public void initDefaultCommand() {
		setDefaultCommand(new MoveArmToPosition(UP_POSITION));
	}

	public void lowerBar(double speed) {
		obstacleMoverMotor.set(-speed);
	}

	public void raiseBar(double speed) {
		obstacleMoverMotor.set(speed);
	}
	
	public void set(double speed){
		obstacleMoverMotor.set(speed);
	}

	public void stopBar() {
		obstacleMoverMotor.set(0);
	}

	public double getAngle(){
		return obstacleMoverEncoder.getDistance();
	}
	
	public boolean isBarUp() {
//		return true;
		return getAngle() <= UP_POSITION;
	}

	public boolean isDown() {
		return getAngle() >= DOWN_POSITION;
	}
}
