package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRockWall extends CommandGroup{
	public AutoRockWall(){
		addSequential(new DriveForward(5));
		addSequential(new AlignWithTarget());
		addSequential(new ShootBoulderIntoHighGoal());
		addSequential(new CalibrateIntake());
	}
}
