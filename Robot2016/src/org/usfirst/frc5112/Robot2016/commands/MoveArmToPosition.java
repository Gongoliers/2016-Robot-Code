package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.PID;
import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArmToPosition extends Command {
	private PID pidController;
	private double targetAngle;
	
	
	public MoveArmToPosition(double targetAngle) {
		requires(Robot.obstacleMover);
		this.targetAngle = targetAngle;
	}

	@Override
	protected void initialize() {
		pidController = new PID(0.12, 0, 0.06, 5);
	}

	@Override
	protected void execute() {
		Robot.obstacleMover.set(pidController.getOutput(Robot.obstacleMover.getAngle(), targetAngle));
		
	}

	@Override
	protected boolean isFinished() {
		return pidController.isAtTargetPosition(Robot.obstacleMover.getAngle(), targetAngle);
	}

	@Override
	protected void end() {
		Robot.obstacleMover.stopBar();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
