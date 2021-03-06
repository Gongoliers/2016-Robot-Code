package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShootBoulderIntoHighGoal extends CommandGroup {
	public ShootBoulderIntoHighGoal() {
		addSequential(new SpinUpFlywheel());
		addParallel(new SpinIntake());
		addSequential(new ElevateBoulderToFlywheel());
		addSequential(new LowerKickerToRestPosition());
		addParallel(new StopFlywheel());
		addSequential(new StopIntake());
	}
}
