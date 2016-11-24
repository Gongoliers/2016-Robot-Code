package org.usfirst.frc5112.Robot2016;

import com.ctre.CANTalon;
import com.thegongoliers.output.SynchronizedSpeedControllers;


public class DualCANTalon extends SynchronizedSpeedControllers {

	public DualCANTalon(int canID1, int canID2) {
		super(new CANTalon(canID1), new CANTalon(canID2));
	}

}