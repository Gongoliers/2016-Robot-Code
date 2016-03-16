package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SpyBotAuto extends CommandGroup {
	public SpyBotAuto() {
		addSequential(new AlignWithTarget());
		addSequential(new ShootBoulderIntoHighGoal());
	}
}
