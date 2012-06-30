package org.neuralnetwork.neuron;

import java.util.Set;

import org.neuralnetwork.synapse.ISynapse;

public interface INeuron<ValueType, SynapseType extends ISynapse<?, ?>> {
	public void addSynapse(SynapseType synapse);

	public void removeSynapse(SynapseType synapse);

	public Set<SynapseType> getSynapses();

	public void computeValue();

	public ValueType getValue();

}
