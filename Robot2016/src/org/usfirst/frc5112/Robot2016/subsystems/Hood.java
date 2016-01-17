// Kyle

package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.RobotMap;
import org.usfirst.frc5112.Robot2016.commands.*;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Hood extends Subsystem {

	private final Servo hoodServo = RobotMap.hoodServo;


	public void initDefaultCommand() {
		setDefaultCommand(new SetHoodPosition(45));
	}

	public void setAngle(double angle) {
		hoodServo.setAngle(angle);
	}

	public double getAngle() {
		return hoodServo.getAngle();
	}
}
