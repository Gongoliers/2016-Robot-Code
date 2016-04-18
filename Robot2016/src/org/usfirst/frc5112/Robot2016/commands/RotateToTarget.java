package org.usfirst.frc5112.Robot2016.commands;

import org.usfirst.frc5112.Robot2016.Robot;

import com.kylecorry.lann.NeuralNetwork;
import com.kylecorry.lann.activation.Linear;
import com.kylecorry.lann.activation.Tanh;
import com.kylecorry.matrix.Matrix;

import edu.wpi.first.wpilibj.command.Command;

public class RotateToTarget extends Command {

	NeuralNetwork net;

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		net = new NeuralNetwork.Builder().addLayer(2, 3, new Linear()).addLayer(3, 1, new Tanh()).build();
	}

	@Override
	protected void execute() {
		Matrix output = net.predict(new Matrix(new double[][] {
				{ (Robot.camera.targetGoal.getCenterX() + 1) / 2.0, Robot.camera.targetGoal.getDistance() / 14.0 } }));
		Robot.driveTrain.rotateCW(output.get(0, 0));
	}

	@Override
	protected boolean isFinished() {
		return Robot.camera.targetGoal.isCenteredHorizontally();
	}

	@Override
	protected void end() {
		Robot.driveTrain.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
