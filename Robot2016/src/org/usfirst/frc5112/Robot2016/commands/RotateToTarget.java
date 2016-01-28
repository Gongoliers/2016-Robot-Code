

package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5112.Robot2016.Robot;

/**
 *
 */
public class RotateToTarget extends Command {
	
	private double TARGET_X_POSITION_THRESHOLD = 0.1;

    public RotateToTarget() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.rotateCW(Robot.camera.targetGoal.centerX);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.camera.targetGoal.centerX) >= TARGET_X_POSITION_THRESHOLD
				&& Robot.camera.targetGoal.isGoal;
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
