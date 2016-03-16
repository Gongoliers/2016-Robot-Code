package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRamparts extends CommandGroup{
	public AutoRamparts(){
		addSequential(new DriveForward(2, 0.7));
		//addSequential(new AlignWithTarget());
		//addSequential(new ShootBoulderIntoHighGoal());
		//addSequential(new CalibrateIntake());
	}
}
