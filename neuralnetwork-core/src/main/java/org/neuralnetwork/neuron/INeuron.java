package org.neuralnetwork.neuron;

import java.util.Set;

import org.neuralnetwork.synapse.ISynapse;

public interface INeuron<Value, Synapse extends ISynapse<?, ?>> {
	public void addSynapse(Synapse synapse);

	public void removeSynapse(Synapse synapse);

	public Set<Synapse> getSynapses();

	public void computeValue();

	public Value getValue();

}
