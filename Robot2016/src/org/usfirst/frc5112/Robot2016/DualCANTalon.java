package org.usfirst.frc5112.Robot2016;

import com.thegongoliers.util.SynchronizedSpeedControllers;

import edu.wpi.first.wpilibj.CANTalon;

public class DualCANTalon extends SynchronizedSpeedControllers {

	public DualCANTalon(int canID1, int canID2) {
		super(new CANTalon(canID1), new CANTalon(canID2));
	}

}