package org.usfirst.frc5112.Robot2016;

import org.usfirst.frc5112.Robot2016.subsystems.Arm;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static DualCANTalon driveTrainLeftDriveMotor;
	public static DualCANTalon driveTrainRightDriveMotor;
	public static RobotDrive driveTrainRobotDrive;
	public static SpeedController intakeIntakeBarMotor;
	public static SpeedController armMotor;
	public static SpeedController shooterFlywheelMotorLeft;
	public static SpeedController shooterFlywheelMotorRight;
	public static SpeedController kickerMotor;
	public static MicrosoftLifeCam robotCamera;
	public static BuiltInAccelerometer accelerometer;
	public static PowerDistributionPanel pdp;
	public static Encoder armEncoder;
	public static AnalogGyro gyro;
	public static DigitalInput autonomousFireLimitSwitch;

	public static int pdpIntakePort = 4;

	public static void init() {
		driveTrainLeftDriveMotor = new DualCANTalon(0, 5);
		driveTrainLeftDriveMotor.setInverted(true);
		driveTrainRightDriveMotor = new DualCANTalon(2, 3);
		driveTrainRightDriveMotor.setInverted(true);
		driveTrainRobotDrive = new RobotDrive(driveTrainLeftDriveMotor, driveTrainRightDriveMotor);

		driveTrainRobotDrive.setSafetyEnabled(true);
		driveTrainRobotDrive.setExpiration(0.1);
		driveTrainRobotDrive.setSensitivity(0.5);
		driveTrainRobotDrive.setMaxOutput(1.0);

		autonomousFireLimitSwitch = new DigitalInput(0);

		armMotor = new Victor(2);
		armEncoder = new Encoder(1, 2);
		armEncoder.setDistancePerPulse(Arm.DEGREES_PER_PULSE);

		intakeIntakeBarMotor = new Victor(1);

		kickerMotor = new Victor(0);

		shooterFlywheelMotorLeft = new CANTalon(4);
		shooterFlywheelMotorRight = new CANTalon(1);

		robotCamera = new MicrosoftLifeCam("cam0");

		accelerometer = new BuiltInAccelerometer();

		pdp = new PowerDistributionPanel();

		gyro = new AnalogGyro(0);
		gyro.initGyro();
	}
}
