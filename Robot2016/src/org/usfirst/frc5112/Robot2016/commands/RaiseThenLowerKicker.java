package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RaiseThenLowerKicker extends CommandGroup {
	public RaiseThenLowerKicker(){
		addSequential(new ElevateBoulderToFlywheel());
		addSequential(new LowerKickerToRestPosition());
	}
}
