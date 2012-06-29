package org.neuralnetwork.synapse;

import org.neuralnetwork.neuron.AbstractNeuron;

public class NeuronSynapse<Value> extends AbstractSynapse<AbstractNeuron<Value>, Value> {

	public NeuronSynapse(AbstractNeuron<Value> input) {
		super(input);
	}

	@Override
	protected Value readValueFrom(AbstractNeuron<Value> input) {
		return input.getValue();
	}
}
