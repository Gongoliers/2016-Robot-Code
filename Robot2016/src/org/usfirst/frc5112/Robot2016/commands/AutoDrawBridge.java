package org.usfirst.frc5112.Robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDrawBridge extends CommandGroup{
	public AutoDrawBridge(){
		addSequential(new LowerArm());
		addSequential(new DriveBackwards(0.5));
		addSequential(new DriveForward(5));
		addSequential(new RaiseArm());
		addSequential(new AlignWithTarget());
		addSequential(new ShootBoulderIntoHighGoal());
		addSequential(new CalibrateIntake());
	}
}
