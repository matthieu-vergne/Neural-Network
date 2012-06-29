package org.neuralnetwork.synapse;

public abstract class AbstractSynapse<InputType, ValueType> {
	private final InputType input;

	public AbstractSynapse(InputType input) {
		this.input = input;
	}

	abstract protected ValueType readValueFrom(InputType input);

	public ValueType getValue() {
		return readValueFrom(input);
	}
}
