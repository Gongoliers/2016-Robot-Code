// Chris V

package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Scaler extends Subsystem {

	private final SpeedController scalerLeftMotor = RobotMap.scalerLeftMotor;
	private final SpeedController scalerRightMotor = RobotMap.scalerRightMotor;
	private final DigitalInput scalerUpLimitSwitch = RobotMap.scalerUpLimitSwitch;
	private final DigitalInput scalerDownLimitSwitch = RobotMap.scalerDownLimitSwitch;
		
	public void initDefaultCommand() {

	}

	public void extend(double speed) {
		scalerLeftMotor.set(speed);
		scalerRightMotor.set(speed);
	}

	public void retract(double speed) {
		scalerLeftMotor.set(speed);
		scalerRightMotor.set(speed);
	}

	public void stop() {
		scalerLeftMotor.set(0);
		scalerRightMotor.set(0);
	}

	public boolean isFullyExtended() {
		return scalerUpLimitSwitch.get(); // limit switch
	}

	public boolean isFullyRetracted() {
		return scalerDownLimitSwitch.get(); // limit switch
	}
}