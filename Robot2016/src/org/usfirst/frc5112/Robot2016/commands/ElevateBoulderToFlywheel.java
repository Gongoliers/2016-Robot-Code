package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class ElevateBoulderToFlywheel extends Command {

	public ElevateBoulderToFlywheel() {
		requires(Robot.kicker);
	}

	@Override
	protected void initialize() {
//		if (Robot.auto) {
//			if (Robot.camera.targetGoal.isGoal())
//				Robot.kicker.up();
//		} else {
			Robot.kicker.up();
//		}
		setTimeout(0.5);

	}

	@Override
	protected void execute() {
		// System.out.println("Flywheel: " + Robot.pdp.getCurrent(5));
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut(); // Robot.kicker.isAtElevatedPosition();
	}

	@Override
	protected void end() {
		Robot.kicker.stop();

	}

	@Override
	protected void interrupted() {
		end();
	}

}
