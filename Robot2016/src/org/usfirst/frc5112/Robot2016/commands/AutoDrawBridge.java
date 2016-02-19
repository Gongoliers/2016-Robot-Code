package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDrawBridge extends CommandGroup{
	public AutoDrawBridge(){
		addSequential(new LowerArm());
		addSequential(new DriveBackwards());
		addSequential(new DriveForwardForFiveSeconds());
		addSequential(new RaiseArm());
		addSequential(new AlignWithTarget());
		addSequential(new ShootBoulderIntoHighGoal());
	}
}
