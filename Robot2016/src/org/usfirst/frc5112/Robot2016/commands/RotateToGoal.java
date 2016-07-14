package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RotateToGoal extends Command {
		
	public RotateToGoal() {
		requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
		Robot.driveTrain.enable();
		Robot.driveTrain.setSetpointRelative(LocateTarget.target.getAngle());
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return Robot.driveTrain.onTarget();
	}

	@Override
	protected void end() {
		Robot.driveTrain.disable();
		Robot.driveTrain.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
