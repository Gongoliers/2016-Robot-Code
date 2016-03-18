package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RotateTowardTarget extends CommandGroup {
	public RotateTowardTarget(int position) {
		if (position == 1) {
			addSequential(new RotateDegrees(-45));
		} else if (position == 2) {
			addSequential(new RotateDegrees(45));
		}
	}
}
