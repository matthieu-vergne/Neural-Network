package org.neuralnetwork.synapse;

public interface ISynapse<InputType, ValueType> {

	public InputType getInput();

	public ValueType getValue();

}
