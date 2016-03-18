package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoMoat extends CommandGroup {
	public AutoMoat() {
		addSequential(new DriveForward(2.5, 0.7));
		if (Robot.shouldFire()) {
			addSequential(new RotateTowardTarget(Robot.getFieldPosition()));
			addSequential(new AlignWithTarget());
			addSequential(new ShootBoulderIntoHighGoal());
			addSequential(new CalibrateIntake());
		}
	}

}
