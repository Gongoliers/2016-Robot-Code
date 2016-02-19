package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;
import org.usfirst.frc5112.Robot2016.subsystems.Camera.CameraMode;

import edu.wpi.first.wpilibj.command.Command;

public class ActivateTargetMode extends Command {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.camera.setCameraMode(CameraMode.TARGET);
		setTimeout(0.5);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
