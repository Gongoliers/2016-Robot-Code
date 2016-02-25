package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AlignWithTargetExperimental extends Command {
	
	PIDController pidController;

    public AlignWithTargetExperimental() {
    	requires(Robot.driveTrain);
    	pidController = new PIDController(0.86, 0.2, 0.25, Robot.camera, Robot.driveTrain);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	pidController.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	pidController.setSetpoint(-0.12);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(pidController.getError()) <= 0.02;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
