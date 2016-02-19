// Kris

package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.RobotMap;
import org.usfirst.frc5112.Robot2016.commands.OperateFlywheel;

import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

	private final SpeedController flywheelMotorLeft = RobotMap.shooterFlywheelMotorLeft;
	private final SpeedController flywheelMotorRight = RobotMap.shooterFlywheelMotorRight;

	public void initDefaultCommand() {
		setDefaultCommand(new OperateFlywheel());
	}

	/**
	 * Sets the fly wheel to a speed. Allow time for flywheel to spin up.
	 * 
	 * @param speed
	 *            The speed of the flywheel. Negative is out and positive is in.
	 */
	public void spinFlyWheel(double speed) {
		speed = Math.max(-0.9, speed);
		speed = Math.min(0.9, speed);
		flywheelMotorLeft.set(speed);
		flywheelMotorRight.set(-speed);
	}

	/**
	 * Stops the flywheel.
	 */
	public void stopFlyWheel() {
		flywheelMotorLeft.set(0);
		flywheelMotorRight.set(0);
	}
}
