package org.neuralnetwork.synapse;

public abstract class AbstractWeightProductSynapse<InputType> extends
		AbstractWeightedSynapse<InputType, Double, Double> {

	public AbstractWeightProductSynapse(InputType input, Double initialWeight) {
		super(input, initialWeight);
	}

	@Override
	protected Double readValueFrom(InputType input, Double weight) {
		return getValueFromInput(input) * weight;
	}

	abstract protected Double getValueFromInput(InputType input);

	@Override
	public String toString() {
		return "(" + getInput() + "*" + getWeight() + ")";
	}
}
