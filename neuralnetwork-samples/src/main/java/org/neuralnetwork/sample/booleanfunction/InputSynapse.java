package org.neuralnetwork.sample.booleanfunction;

import org.neuralnetwork.synapse.AbstractWeightedSynapse;

public class InputSynapse extends AbstractWeightedSynapse<Input> {

	public InputSynapse(Input input, Double initialWeight) {
		super(input, initialWeight);
	}

	@Override
	protected Double getValueFromInput(Input input) {
		return input.value == true ? 1.0 : 0.0;
	}

}
