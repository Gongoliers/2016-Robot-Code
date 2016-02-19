package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRoughtTerrain extends CommandGroup{
	public AutoRoughtTerrain(){
		addSequential(new DriveForwardForFiveSeconds());
		addSequential(new AlignWithTarget());
		addSequential(new ShootBoulderIntoHighGoal());	}
	//FIX NAME
}
