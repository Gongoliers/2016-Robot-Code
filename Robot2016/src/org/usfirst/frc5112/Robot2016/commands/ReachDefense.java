package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ReachDefense extends CommandGroup {
	public ReachDefense(){
		addSequential(new DriveForward(0.5));
	}
}
