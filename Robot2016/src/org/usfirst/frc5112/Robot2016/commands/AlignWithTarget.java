package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Aligns to target.
 */
public class AlignWithTarget extends CommandGroup {

	public AlignWithTarget() {
		addSequential(new ActivateTargetMode());
		addParallel(new LocateTarget());
		addParallel(new RotateToTarget());
	}
}
