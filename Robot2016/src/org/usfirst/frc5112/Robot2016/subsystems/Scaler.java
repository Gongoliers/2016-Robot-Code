// Chris V

package org.usfirst.frc5112.Robot2016.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Scaler extends Subsystem {

	public void initDefaultCommand() {

	}

	/**
	 * Extends the scaler.
	 * 
	 * @param speed
	 *            The speed at which the scaler will move.
	 */
	public void extend(double speed) {

	}

	/**
	 * Retracts the scaler.
	 * 
	 * @param speed
	 *            The speed at which the scaler will move.
	 */
	public void retract(double speed) {

	}

	/**
	 * Tell whether the scaler is fully extended.
	 * 
	 * @return true if the scaler is fully extended, false otherwise.
	 */
	public boolean isFullyExtended() {
		return true; // limit switch
	}

	/**
	 * Tell whether the scaler is fully retracted.
	 * 
	 * @return true if the scaler is fully retracted, false otherwise.
	 */
	public boolean isFullyRetracted() {
		return true; // limit switch
	}
}