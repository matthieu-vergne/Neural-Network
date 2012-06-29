package org.neuralnetwork.synapse;

import org.neuralnetwork.neuron.AbstractNeuron;

public class NeuronSynapse<ValueType> extends AbstractSynapse<AbstractNeuron<ValueType, ?>, ValueType> {

	public NeuronSynapse(AbstractNeuron<ValueType, ?> input) {
		super(input);
	}

	@Override
	protected ValueType readValueFrom(AbstractNeuron<ValueType, ?> input) {
		return input.getValue();
	}
}
