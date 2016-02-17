package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Aligns to target.
 */
public class AlignWithTarget extends CommandGroup {

	public AlignWithTarget() {
		addParallel(new LocateTarget());
//		addParallel(new RotateToTarget());
	}
}
