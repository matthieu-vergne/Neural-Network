package org.neuralnetwork.neuron;

import java.util.HashSet;
import java.util.Set;

import org.neuralnetwork.synapse.AbstractSynapse;

public abstract class AbstractNeuron<ValueType, SynapseType extends AbstractSynapse<?, ?>> {
	private ValueType value;
	private final Set<SynapseType> synapses = new HashSet<SynapseType>();

	public AbstractNeuron(ValueType initialValue) {
		value = initialValue;
	}

	public ValueType getValue() {
		return value;
	}

	public void addSynapse(SynapseType synapse) {
		synapses.add(synapse);
	}

	public void removeSynapse(SynapseType synapse) {
		synapses.remove(synapse);
	}

	abstract protected ValueType computeValueFromInputs(
			Set<SynapseType> inputs);

	public void computeValue() {
		value = computeValueFromInputs(synapses);
	}
}
