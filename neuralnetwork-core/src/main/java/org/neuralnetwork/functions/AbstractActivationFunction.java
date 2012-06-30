package org.neuralnetwork.functions;

public abstract class AbstractActivationFunction<Input, Output> {
	public abstract Output compute(Input input);
}
