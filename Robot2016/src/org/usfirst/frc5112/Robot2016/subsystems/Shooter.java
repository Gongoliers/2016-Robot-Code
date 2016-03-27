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

	private final double[] shooterSpeeds = new double[] { -1, -1, -1, -1, -1, -1, -0.66, -0.62, -0.61, -0.62, -0.62, -0.61, -0.61, -0.64, -0.64, -0.63, -0.7, -0.7, -0.7, -0.68 };

	/**
	 * Gets the required shooting speed at a given distance.
	 * 
	 * @param distance
	 *            The distance to the goal in feet.
	 * @return The speed of the shooter.
	 */
	public double getShooterSpeedAtDistance(double distance) {
		double distancePosition = Math.round(distance);
		distancePosition = Math.max(0, distancePosition);
		distancePosition = Math.min(distancePosition, shooterSpeeds.length-1);
		return shooterSpeeds[(int) distancePosition];
	}

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
