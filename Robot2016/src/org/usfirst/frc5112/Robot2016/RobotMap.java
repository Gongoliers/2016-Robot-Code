package org.usfirst.frc5112.Robot2016;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

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
	public static SpeedController scalerLeftMotor;
	public static SpeedController scalerRightMotor;
	public static SpeedController intakeIntakeBarMotor;
	public static SpeedController obstacleMoverMotor;
	public static SpeedController shooterFlywheelMotorLeft;
	public static SpeedController shooterFlywheelMotorRight;
	public static SpeedController elevatorMotor;
	public static MicrosoftLifeCam robotCamera;
	public static BuiltInAccelerometer accelerometer;
	public static PowerDistributionPanel pdp;
	public static Encoder elevatorEncoder;
	public static AnalogGyro gyro;

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
		
		scalerLeftMotor = new Victor(3);
		scalerRightMotor = new Victor(4);
		
		obstacleMoverMotor = new Victor(2);

		intakeIntakeBarMotor = new Victor(1);

		elevatorMotor = new Victor(0);
		elevatorEncoder = new Encoder(0, 1);

		shooterFlywheelMotorLeft = new CANTalon(4);
		shooterFlywheelMotorRight = new CANTalon(1);

		robotCamera = new MicrosoftLifeCam("cam0");

		accelerometer = new BuiltInAccelerometer();

		pdp = new PowerDistributionPanel();
		
		gyro = new AnalogGyro(0);
		gyro.initGyro();
	}
}
