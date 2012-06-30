package org.neuralnetwork.functions;

public interface IActivationFunction<Input, Output> {
	public Output compute(Input input);
}
