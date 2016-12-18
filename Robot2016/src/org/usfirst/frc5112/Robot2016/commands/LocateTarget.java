package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5112.Robot2016.Robot;

import com.thegongoliers.input.camera.Camera.Target;

/**
 * Used to detect the high goal target.
 */
public class LocateTarget extends Command {

	public static volatile boolean locatingTarget = false;
	private Thread visionThread;

	public static Target target;

	public LocateTarget() {
		requires(Robot.camera);
		target = new Target();
	}

	protected void initialize() {
		Robot.camera.enableTargetMode();
//		visionThread = new Thread(() -> {
			locatingTarget = true;
			try {
				target = Robot.camera.findHighGoal();
				System.out.println(target);
				System.out.println(target.getCenterX());
			} catch (Exception e) {
				System.out.println("Target not found");
				e.printStackTrace();
				return;
			} finally {
				locatingTarget = false;
			}
			SmartDashboard.putNumber("Goal Center X", target.getCenterX());
			SmartDashboard.putNumber("Goal distance", target.getDistance());
			SmartDashboard.putNumber("Goal Angle", target.getAngle());
//		});
//		visionThread.start();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return !locatingTarget;
	}

	protected void end() {
		Robot.camera.disableTargetMode();
	}

	protected void interrupted() {
		end();
	}
}
