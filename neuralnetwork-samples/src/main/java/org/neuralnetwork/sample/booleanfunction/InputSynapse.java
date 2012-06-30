package org.neuralnetwork.sample.booleanfunction;

import org.neuralnetwork.synapse.AbstractWeightProductSynapse;

public class InputSynapse extends AbstractWeightProductSynapse<Input> {

	public InputSynapse(Input input, Double initialWeight) {
		super(input, initialWeight);
	}

	@Override
	protected Double getValueFromInput(Input input) {
		return input.value == true ? 1.0 : 0.0;
	}

}
