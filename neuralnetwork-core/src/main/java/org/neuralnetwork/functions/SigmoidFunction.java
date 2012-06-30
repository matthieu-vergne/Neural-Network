package org.neuralnetwork.functions;

public class SigmoidFunction implements IActivationFunction<Double, Double> {
	private final double lambda;

	public SigmoidFunction() {
		this(1.0);
	}

	public SigmoidFunction(double lambda) {
		this.lambda = lambda;
	}

	@Override
	public Double compute(Double input) {
		return 1 / (1 + Math.exp(-input * lambda));
	}

	public double getLambda() {
		return lambda;
	}
}
