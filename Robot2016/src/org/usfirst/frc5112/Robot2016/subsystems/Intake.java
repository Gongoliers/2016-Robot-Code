// SquidwardAndCo

package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

	private final SpeedController intakeBarMotor = RobotMap.intakeIntakeBarMotor;

	public void initDefaultCommand() {

	}

	public void setBarSpeed(double speed) {
		intakeBarMotor.set(-speed);
	}

	public void stopBar() {
		intakeBarMotor.set(0);
	}

	public boolean hasBoulder() {
		return true;
	}
}
