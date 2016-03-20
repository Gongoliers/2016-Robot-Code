package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRamparts extends CommandGroup {
	public AutoRamparts() {
		addSequential(new DriveForward(1.9, 0.75));
		addSequential(new RotateTowardTarget(Robot.getFieldPosition()));
		addSequential(new AlignWithTarget());
		if (Robot.shouldFire()) {
			addSequential(new ShootBoulderIntoHighGoal());
			addSequential(new CalibrateIntake());
		}
	}
}
