package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.PID;
import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArmToPosition extends Command {
	private double targetAngle;
	
	
	public MoveArmToPosition(double targetAngle) {
		requires(Robot.obstacleMover);
		this.targetAngle = targetAngle;
	}

	@Override
	protected void initialize() {
		Robot.obstacleMover.enable();
	}

	@Override
	protected void execute() {
		Robot.obstacleMover.setSetpoint(targetAngle);
	}

	@Override
	protected boolean isFinished() {
		return Robot.obstacleMover.onTarget();
	}

	@Override
	protected void end() {
		Robot.obstacleMover.stopBar();
		Robot.obstacleMover.disable();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
