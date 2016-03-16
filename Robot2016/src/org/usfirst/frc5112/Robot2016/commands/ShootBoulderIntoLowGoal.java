package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PrintCommand;

public class ShootBoulderIntoLowGoal extends CommandGroup {
	public ShootBoulderIntoLowGoal() {
		addSequential(new PrepareBoulderForLowGoal());
		addSequential(new DriveForward(0.8));
		addSequential(new RollBoulderIntoLowGoal());
	}
}
