package org.neuralnetwork.synapse;

public abstract class AbstractSynapse<Input, Value> implements
		ISynapse<Input, Value> {
	private final Input input;

	public AbstractSynapse(Input input) {
		this.input = input;
	}

	abstract protected Value readValueFrom(Input input);

	@Override
	public Value getValue() {
		return readValueFrom(input);
	}

	@Override
	public String toString() {
		return "" + getValue();
	}

	@Override
	public Input getInput() {
		return input;
	}
}
