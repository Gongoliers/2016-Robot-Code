package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5112.Robot2016.Robot;

/**
 *
 */
public class SetHoodPosition extends Command {

    private double m_position;
 
    public SetHoodPosition(double position) {
        m_position = position;
        requires(Robot.hood);
    }

    protected void initialize() {
    	Robot.hood.setAngle(m_position);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return Robot.hood.getAngle() == m_position;
    }

    protected void end() {
    }


    protected void interrupted() {
    	end();
    }
}
