package org.neuralnetwork.synapse;

public abstract class AbstractWeightedSynapse<InputType, ValueType, WeightType extends Number> extends AbstractSynapse<InputType, ValueType> {
	private WeightType weight;
	
	public AbstractWeightedSynapse(InputType input, WeightType initialWeight) {
		super(input);
		setWeight(initialWeight);
	}

	abstract protected ValueType readValueFrom(InputType input, WeightType weight);
	
	@Override
	protected ValueType readValueFrom(InputType input) {
		return readValueFrom(input, getWeight());
	}

	public WeightType getWeight() {
		return weight;
	}

	public void setWeight(WeightType weight) {
		this.weight = weight;
	}
	
}
