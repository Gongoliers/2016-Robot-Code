package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShootBoulderIntoHighGoal extends CommandGroup {
	public ShootBoulderIntoHighGoal() {		
		addSequential(new SpinUpFlywheel());
		addSequential(new ElevateBoulderToFlywheel());
		addSequential(new LowerKickerToRestPosition());
		addSequential(new StopFlywheel());
	}
}
