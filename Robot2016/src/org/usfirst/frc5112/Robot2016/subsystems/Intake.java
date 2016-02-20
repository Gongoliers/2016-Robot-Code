package org.usfirst.frc5112.Robot2016.subsystems;

import org.usfirst.frc5112.Robot2016.RobotMap;
import org.usfirst.frc5112.Robot2016.commands.OperateIntake;

import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

	private final SpeedController intakeBarMotor = RobotMap.intakeIntakeBarMotor;

	private double freeCurrent = 7.6;
	
	public void initDefaultCommand() {
		setDefaultCommand(new OperateIntake());
	}

	/**
	 * Sets the speed of the intake bars.
	 * @param speed The speed of the intake bars. Negative is in, positive is out.
	 */
	public void setBarSpeed(double speed) {
		intakeBarMotor.set(speed);
	}

	public void stopBar() {
		intakeBarMotor.set(0);
	}

	public boolean hasBoulder() {
		return true; // need a limit switch here
	}
	
	public void setFreeCurrent(double c){
		freeCurrent = c;
	}
	
	public double getFreeCurrent(){
		return freeCurrent;
	}
}
