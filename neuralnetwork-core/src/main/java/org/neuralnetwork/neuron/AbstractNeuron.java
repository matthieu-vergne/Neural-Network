package org.neuralnetwork.neuron;

import java.util.HashSet;
import java.util.Set;

import org.neuralnetwork.synapse.ISynapse;

public abstract class AbstractNeuron<ValueType, SynapseType extends ISynapse<?, ?>>
		implements INeuron<ValueType, SynapseType> {
	private ValueType value;
	private final Set<SynapseType> synapses = new HashSet<SynapseType>();

	public AbstractNeuron(ValueType initialValue) {
		value = initialValue;
	}

	@Override
	public ValueType getValue() {
		return value;
	}

	@Override
	public void addSynapse(SynapseType synapse) {
		synapses.add(synapse);
	}

	@Override
	public void removeSynapse(SynapseType synapse) {
		synapses.remove(synapse);
	}

	abstract protected ValueType computeValueFromInputs(Set<SynapseType> inputs);

	@Override
	public void computeValue() {
		value = computeValueFromInputs(synapses);
	}

	@Override
	public Set<SynapseType> getSynapses() {
		return synapses;
	}

	@Override
	public String toString() {
		return synapses.toArray().toString();
	}
}
