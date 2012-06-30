package org.neuralnetwork.synapse;

public abstract class AbstractSynapse<InputType, ValueType> implements
		ISynapse<InputType, ValueType> {
	private final InputType input;

	public AbstractSynapse(InputType input) {
		this.input = input;
	}

	abstract protected ValueType readValueFrom(InputType input);

	@Override
	public ValueType getValue() {
		return readValueFrom(input);
	}

	@Override
	public String toString() {
		return "" + getValue();
	}

	@Override
	public InputType getInput() {
		return input;
	}
}
