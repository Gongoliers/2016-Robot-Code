package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoChevalDeFrise extends CommandGroup {
	public AutoChevalDeFrise() {
		addSequential(new LowerArm());
		addSequential(new DriveForward(2.5, 0.7));
		addSequential(new RaiseArm());
		addSequential(new RotateTowardTarget(Robot.getFieldPosition()));
		addSequential(new AlignWithTarget());
		if (Robot.shouldFire()) {
			addSequential(new ShootBoulderIntoHighGoal());
			addSequential(new CalibrateIntake());
		}
	}
}