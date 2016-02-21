package org.usfirst.frc5112.Robot2016;

import org.usfirst.frc5112.Robot2016.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public Joystick driveStick;
	public XboxController xbox;
	public JoystickButton driveStickTrigger;
	public JoystickButton driveStickSideButton;
	public JoystickButton driveStickButton3;
	public JoystickButton driveStickButton4;

	public OI() {
		xbox = new XboxController(1);
		driveStick = new Joystick(0);

		driveStickTrigger = new JoystickButton(driveStick, 1);
		driveStickSideButton = new JoystickButton(driveStick, 2);
		driveStickButton3 = new JoystickButton(driveStick, 3);
		driveStickButton4 = new JoystickButton(driveStick, 4);

		xbox.RT.whenActive(new ShootBoulderIntoHighGoal());
		xbox.LT.whenActive(new IntakeBoulder());
		xbox.A.whenPressed(new RaiseThenLowerKicker());
		xbox.START.whenPressed(new StopIntakeAndFlywheel());
		xbox.LB.whileHeld(new RaiseArm());
		xbox.RB.whileHeld(new LowerArm());
		xbox.DPAD_UP.whenActive(new ExtendScaler());
		xbox.DPAD_UP.whenInactive(new StopScaler());
		xbox.DPAD_DOWN.whenActive(new RetractScaler());
		xbox.DPAD_DOWN.whenInactive(new StopScaler());

		driveStickTrigger.whileHeld(new AlignWithTarget());
		driveStickSideButton.whenPressed(new StopDriveTrain());
		driveStickButton3.whenPressed(new CalibrateIntake());

		// SmartDashboard Button
		SmartDashboard.putData("Display Normal Camera Image", new DisplayNormalCameraImage());

	}

	public Joystick getDriveStick() {
		return driveStick;
	}

	public Joystick getXbox() {
		return xbox;
	}

}
