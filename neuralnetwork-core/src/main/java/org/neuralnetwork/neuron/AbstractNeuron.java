package org.neuralnetwork.neuron;

import java.util.HashSet;
import java.util.Set;

import org.neuralnetwork.synapse.AbstractSynapse;

public abstract class AbstractNeuron<Value> {
	private Value value;
	private Set<AbstractSynapse<?, ?>> inputs = new HashSet<AbstractSynapse<?, ?>>();

	public AbstractNeuron(Value initialValue) {
		value = initialValue;
	}

	public Value getValue() {
		return value;
	}

	public void addSynapse(AbstractSynapse<?, ?> synapse) {
		inputs.add(synapse);
	}

	public void removeSynapse(AbstractSynapse<?, ?> synapse) {
		inputs.remove(synapse);
	}

	abstract protected Value computeValueFromInputs(
			Set<AbstractSynapse<?, ?>> inputs);

	public void computeValue() {
		value = computeValueFromInputs(inputs);
	}
}
