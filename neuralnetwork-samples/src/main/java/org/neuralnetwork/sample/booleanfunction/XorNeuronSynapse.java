package org.neuralnetwork.sample.booleanfunction;

import org.neuralnetwork.neuron.AbstractNeuron;
import org.neuralnetwork.synapse.AbstractWeightProductSynapse;

public class XorNeuronSynapse extends AbstractWeightProductSynapse<AbstractNeuron<Double, ?>> {

	public XorNeuronSynapse(AbstractNeuron<Double, ?> input, Double initialWeight) {
		super(input, initialWeight);
	}

	@Override
	protected Double getValueFromInput(AbstractNeuron<Double, ?> input) {
		return input.getValue();
	}


}
