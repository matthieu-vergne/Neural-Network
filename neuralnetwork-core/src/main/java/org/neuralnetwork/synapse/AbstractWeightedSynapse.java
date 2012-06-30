package org.neuralnetwork.synapse;

public abstract class AbstractWeightedSynapse<InputType> extends
		AbstractSynapse<InputType, Double> {
	private Double weight;

	public AbstractWeightedSynapse(InputType input, Double initialWeight) {
		super(input);
		setWeight(initialWeight);
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	protected Double readValueFrom(InputType input) {
		return getValueFromInput(input) * weight;
	};

	abstract protected Double getValueFromInput(InputType input);

	@Override
	public String toString() {
		return "(" + getValueFromInput(getInput()) + "*" + getWeight() + ")";
	}
}
