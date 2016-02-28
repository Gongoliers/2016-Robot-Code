package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.RobotMap;
import org.usfirst.frc5112.Robot2016.commands.RaiseArm;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ObstacleMover extends Subsystem {

	private final SpeedController obstacleMoverMotor = RobotMap.obstacleMoverMotor;
	private final DigitalInput obstacleMoverLimitSwitch = RobotMap.obstacleArmLimitSwitch;
	private final Encoder obstacleMoverEncoder = RobotMap.obstacleMoverEncoder;

	public static final int UP_POSITION = 0;
	public static final int DOWN_POSITION = 100;

	public void initDefaultCommand() {
		setDefaultCommand(new RaiseArm());
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

	public boolean isBarUp() {
		return obstacleMoverLimitSwitch.get(); // || obstacleMoverEncoder.get()
												// <= UP_POSITION;
	}

	public boolean isDown() {
		return obstacleMoverEncoder.get() >= DOWN_POSITION;
	}
}
