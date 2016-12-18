package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AlignWithTarget extends CommandGroup{

	public AlignWithTarget() {
		addSequential(new LocateTarget(), 1.5);
		addSequential(new WaitCommand(5));
		addSequential(new RotateDegrees());
	}
	
}
