package org.usfirst.frc5112.Robot2016;

import org.usfirst.frc5112.Robot2016.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public Joystick driveStick;
	public Joystick xbox;
	public JoystickButton xboxRB;
	public JoystickButton xboxLB;
	public JoystickButton xboxStart;
	public JoystickButton driveStickTrigger;
	public JoystickButton driveStickSideButton;

	public OI() {
		xbox = new Joystick(1);

		driveStick = new Joystick(0);

		xboxRB = new JoystickButton(xbox, 6);
		xboxLB = new JoystickButton(xbox, 5);
		xboxStart = new JoystickButton(xbox, 8);
		driveStickTrigger = new JoystickButton(driveStick, 1);
		driveStickSideButton = new JoystickButton(driveStick, 2);

		xboxRB.whenPressed(new ShootBoulderIntoHighGoal());
		xboxLB.whenPressed(new IntakeBoulder());
		xboxStart.whenPressed(new StopIntakeAndFlywheel());
		
		driveStickTrigger.whileHeld(new AlignWithTarget());
		driveStickSideButton.whenPressed(new StopDriveTrain());

		// SmartDashboard Button
		SmartDashboard.putData("Shoot boulder into high goal", new ShootBoulderIntoHighGoal());
		SmartDashboard.putData("Intake Boulder", new IntakeBoulder());
		SmartDashboard.putData("Display Normal Camera Image", new DisplayNormalCameraImage());
		SmartDashboard.putData("Align With Target", new AlignWithTarget());

	}

	public Joystick getDriveStick() {
		return driveStick;
	}

	public Joystick getShootStick() {
		return xbox;
	}

}
