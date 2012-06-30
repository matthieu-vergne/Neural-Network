package org.neuralnetwork.neuron;

import java.util.HashSet;
import java.util.Set;

import org.neuralnetwork.synapse.ISynapse;

public abstract class AbstractNeuron<Value, Synapse extends ISynapse<?, ?>>
		implements INeuron<Value, Synapse> {
	private Value value;
	private final Set<Synapse> synapses = new HashSet<Synapse>();

	public AbstractNeuron(Value initialValue) {
		value = initialValue;
	}

	@Override
	public Value getValue() {
		return value;
	}

	@Override
	public void addSynapse(Synapse synapse) {
		synapses.add(synapse);
	}

	@Override
	public void removeSynapse(Synapse synapse) {
		synapses.remove(synapse);
	}

	abstract protected Value computeValueFromInputs(Set<Synapse> inputs);

	@Override
	public void computeValue() {
		value = computeValueFromInputs(synapses);
	}

	@Override
	public Set<Synapse> getSynapses() {
		return synapses;
	}

	@Override
	public String toString() {
		return synapses.toArray().toString();
	}
}
