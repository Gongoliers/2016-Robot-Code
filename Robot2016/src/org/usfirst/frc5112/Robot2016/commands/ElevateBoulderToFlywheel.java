package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;
import org.usfirst.frc5112.Robot2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ElevateBoulderToFlywheel extends Command {

	public ElevateBoulderToFlywheel() {
		requires(Robot.kicker);
	}

	@Override
	protected void initialize() {
		Robot.kicker.up();
		setTimeout(0.5);
		System.out.println("Raise kicker Init");

	}

	@Override
	protected void execute() {
//		System.out.println("Flywheel: " + Robot.pdp.getCurrent(5));
		System.out.println(Robot.kicker.get());
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut(); // Robot.kicker.isAtElevatedPosition();
	}

	@Override
	protected void end() {
		Robot.kicker.stop();
		System.out.println("Raise kicker end");
		System.out.println(Robot.kicker.get());


	}

	@Override
	protected void interrupted() {
		end();
	}

}
