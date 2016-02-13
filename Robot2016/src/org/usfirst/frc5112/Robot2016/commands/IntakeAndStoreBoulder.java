package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeAndStoreBoulder extends CommandGroup {
	public IntakeAndStoreBoulder() {
		addSequential(new LowerKickerToRestPosition());
		addSequential(new IntakeBoulder());
	}
}
