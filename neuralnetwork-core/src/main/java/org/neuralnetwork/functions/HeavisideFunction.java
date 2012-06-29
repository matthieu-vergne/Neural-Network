package org.neuralnetwork.functions;

public class HeavisideFunction extends
		AbstractActivationFunction<Double, Double> {

	private final double threshold;

	public HeavisideFunction() {
		this(0);
	}

	public HeavisideFunction(double threshold) {
		this.threshold = threshold;
	}

	@Override
	public Double compute(Double input) {
		return input >= threshold ? 1.0 : 0.0;
	}

	public double getThreshold() {
		return threshold;
	}

}
