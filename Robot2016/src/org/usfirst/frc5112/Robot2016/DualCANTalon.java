package org.usfirst.frc5112.Robot2016;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;

public class DualCANTalon implements SpeedController {
	
	private CANTalon talons[];
	
	public DualCANTalon(int canID1, int canID2) {
		this(new CANTalon(canID1), new CANTalon(canID2));
	}
	
	public DualCANTalon(CANTalon talon1, CANTalon talon2) {
		talons[0] = talon1;
		talons[1] = talon2;
	}

	@Override
	public void pidWrite(double output) {
		talons[0].pidWrite(output);
		talons[1].pidWrite(output);
	}

	@Override
	public double get() {
		return talons[0].get();
	}

	@Override
	public void set(double speed, byte syncGroup) {
		this.set(speed);
	}

	@Override
	public void set(double speed) {
		talons[0].set(speed);
		talons[1].set(speed);
	}

	@Override
	public void setInverted(boolean isInverted) {
		talons[0].setInverted(isInverted);
		talons[1].setInverted(isInverted);
	}

	@Override
	public boolean getInverted() {
		return talons[0].getInverted();
	}

	@Override
	public void disable() {
		talons[0].disable();
		talons[1].disable();
	}
	
}