package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StopIntakeAndFlywheel extends CommandGroup {
    
    public  StopIntakeAndFlywheel() {
        addParallel(new StopFlywheel());
        addSequential(new StopIntake());
    }
}
