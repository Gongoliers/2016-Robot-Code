// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc5112.Robot2016;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5112.Robot2016.commands.*;
import org.usfirst.frc5112.Robot2016.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Command autonomousCommand;

	public static OI oi;
	public static DriveTrain driveTrain;
	public static Scaler scaler;
	public static ObstacleMover obstacleMover;
	public static Intake intake;
	public static Camera camera;
	public static Shooter shooter;
	public static Kicker kicker;
	public static PowerDistributionPanel pdp;
	public static AnalogGyro gyro;
	public static Accelerometer accel;

	private SendableChooser autoChooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		RobotMap.init();
		driveTrain = new DriveTrain();
		scaler = new Scaler();
		obstacleMover = new ObstacleMover();
		intake = new Intake();
		camera = new Camera();
		shooter = new Shooter();
		kicker = new Kicker();
		pdp = RobotMap.pdp;
		gyro = RobotMap.gyro;
		accel = new Accelerometer();
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Do nothing", new StopDriveTrain());
		autoChooser.addObject("Cheval De Frise", new AutoChevalDeFrise());
		autoChooser.addObject("Draw Bridge", new AutoDrawBridge());
		autoChooser.addObject("Moat", new AutoMoat());
		autoChooser.addObject("Ramparts", new AutoRamparts());
		autoChooser.addObject("Rock Wall", new AutoRockWall());
		autoChooser.addObject("Sally Port", new AutoSallyPort());
		SmartDashboard.putData("Autonomous Chooser", autoChooser);
		
		gyro.calibrate();
		// gyro.reset();

		oi = new OI();

	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		autonomousCommand = (Command) autoChooser.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
