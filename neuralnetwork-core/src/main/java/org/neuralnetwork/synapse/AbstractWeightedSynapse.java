package org.neuralnetwork.synapse;

public abstract class AbstractWeightedSynapse<Input> extends
		AbstractSynapse<Input, Double> {
	private Double weight;

	public AbstractWeightedSynapse(Input input, Double initialWeight) {
		super(input);
		setWeight(initialWeight);
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	protected Double readValueFrom(Input input) {
		return getValueFromInput(input) * weight;
	};

	abstract protected Double getValueFromInput(Input input);

	@Override
	public String toString() {
		return "(" + getValueFromInput(getInput()) + "*" + getWeight() + ")";
	}
}
