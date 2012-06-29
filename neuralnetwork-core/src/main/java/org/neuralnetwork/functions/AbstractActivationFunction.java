package org.neuralnetwork.functions;

public abstract class AbstractActivationFunction<InputType, OutputType> {
	public abstract OutputType compute(InputType input);
}
