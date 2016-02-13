package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShootBoulderIntoHighGoal extends CommandGroup {
	public ShootBoulderIntoHighGoal() {
		addSequential(new SpinUpFlywheel());
		addSequential(new ElevateBoulderToFlywheel());
		addParallel(new LowerKickerToRestPosition());
		addParallel(new StopFlywheel());
	}
}
