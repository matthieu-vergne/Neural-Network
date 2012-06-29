package org.neuralnetwork.synapse;

public abstract class AbstractSynapse<In, Value> {
	private final In input;

	public AbstractSynapse(In input) {
		this.input = input;
	}

	abstract protected Value readValueFrom(In input);

	public Value getValue() {
		return readValueFrom(input);
	}
}
