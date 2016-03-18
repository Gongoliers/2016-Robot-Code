package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoSallyPort extends CommandGroup {
	public AutoSallyPort() {
		addSequential(new DriveForward(0.75, 0.7));
		addParallel(new LowerArm());
		addSequential(new DriveBackwards(0.5));
		addSequential(new DriveForward(2.5));
		addParallel(new RaiseArm());
		if (Robot.shouldFire()) {
			addSequential(new RotateTowardTarget(Robot.getFieldPosition()));
			addSequential(new AlignWithTarget());
			addSequential(new ShootBoulderIntoHighGoal());
			addSequential(new CalibrateIntake());
		}
	}
}
