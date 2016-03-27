package org.usfirst.frc5112.Robot2016.commands.auto;

import org.usfirst.frc5112.Robot2016.commands.AlignWithTarget;
import org.usfirst.frc5112.Robot2016.commands.ShootBoulderIntoHighGoal;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SpyBotAuto extends CommandGroup {
	public SpyBotAuto() {
		addSequential(new AlignWithTarget());
		addSequential(new ShootBoulderIntoHighGoal());
	}
}
