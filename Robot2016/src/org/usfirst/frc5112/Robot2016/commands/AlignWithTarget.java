package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AlignWithTarget extends CommandGroup{

	public AlignWithTarget() {
		addSequential(new LocateTarget(), 1.5);
		addSequential(new RotateDegrees());
	}
	
}
