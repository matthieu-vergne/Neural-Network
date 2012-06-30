package org.neuralnetwork.neuron;

import java.util.Set;

import org.neuralnetwork.functions.AbstractActivationFunction;
import org.neuralnetwork.functions.SigmoidFunction;
import org.neuralnetwork.synapse.AbstractSynapse;
import org.neuralnetwork.synapse.AbstractWeightProductSynapse;
import org.neuralnetwork.synapse.AbstractWeightedSynapse;

public class DefaultNeuron extends
		AbstractNeuron<Double, AbstractWeightedSynapse<?, Double, Double>> {

	private final AbstractWeightProductSynapse<Double> biasSynapse = new AbstractWeightProductSynapse<Double>(
			-1.0, 0.0) {
		@Override
		protected Double getValueFromInput(Double input) {
			return input;
		}
	};
	private AbstractActivationFunction<Double, Double> activationFunction = new SigmoidFunction();

	public DefaultNeuron(Double initialValue) {
		super(initialValue);
		addSynapse(biasSynapse);
	}

	@Override
	protected Double computeValueFromInputs(
			Set<AbstractWeightedSynapse<?, Double, Double>> inputs) {
		Double value = 0.0;
		for (AbstractSynapse<?, Double> synapse : inputs) {
			value += synapse.getValue();
		}
		return activationFunction.compute(value);
	}

	public AbstractActivationFunction<Double, Double> getActivationFunction() {
		return activationFunction;
	}

	public void setActivationFunction(
			AbstractActivationFunction<Double, Double> activationFunction) {
		this.activationFunction = activationFunction;
	}

	public void setThreshold(double threshold) {
		biasSynapse.setWeight(threshold);
	}

	public double getThreshold() {
		return biasSynapse.getWeight();
	}

	public boolean isActive() {
		return getValue() >= getThreshold();
	}
}
