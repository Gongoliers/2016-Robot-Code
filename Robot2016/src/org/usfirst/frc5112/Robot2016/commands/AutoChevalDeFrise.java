package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoChevalDeFrise extends CommandGroup{
	public AutoChevalDeFrise(){
		addSequential(new LowerArm());
		addSequential(new DriveForwardForFiveSeconds());
		addSequential(new RaiseArm());
		addSequential(new AlignWithTarget());
		addSequential(new ShootBoulderIntoHighGoal());
	}
}