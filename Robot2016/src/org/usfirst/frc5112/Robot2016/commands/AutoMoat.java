package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoMoat extends CommandGroup {
	public AutoMoat() {
		addSequential(new DriveForwardForFiveSeconds());
		addSequential(new AlignWithTarget());
		addSequential(new ShootBoulderIntoHighGoal());
	}
	
}
