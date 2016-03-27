package org.usfirst.frc5112.Robot2016.commands.auto;

import org.usfirst.frc5112.Robot2016.Robot;
import org.usfirst.frc5112.Robot2016.commands.AlignWithTarget;
import org.usfirst.frc5112.Robot2016.commands.CalibrateIntake;
import org.usfirst.frc5112.Robot2016.commands.DriveForward;
import org.usfirst.frc5112.Robot2016.commands.RotateTowardTarget;
import org.usfirst.frc5112.Robot2016.commands.ShootBoulderIntoHighGoal;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoMoat extends CommandGroup {
	public AutoMoat() {
		addSequential(new DriveForward(2.25, 0.85));
		addSequential(new RotateTowardTarget(Robot.getFieldPosition()));
		addSequential(new AlignWithTarget());
		if (Robot.shouldFire()) {			
			addSequential(new ShootBoulderIntoHighGoal());
			addSequential(new CalibrateIntake());
		}
	}

}
