package org.usfirst.frc5112.Robot2016.commands.auto;

import org.usfirst.frc5112.Robot2016.Robot;
import org.usfirst.frc5112.Robot2016.commands.AlignWithTarget;
import org.usfirst.frc5112.Robot2016.commands.CalibrateIntake;
import org.usfirst.frc5112.Robot2016.commands.DriveForward;
import org.usfirst.frc5112.Robot2016.commands.RotateTowardTarget;
import org.usfirst.frc5112.Robot2016.commands.ShootBoulderIntoHighGoal;

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
