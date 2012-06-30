package org.neuralnetwork.neuron;

import java.util.Set;

import org.neuralnetwork.functions.IActivationFunction;
import org.neuralnetwork.functions.SigmoidFunction;
import org.neuralnetwork.synapse.AbstractSynapse;
import org.neuralnetwork.synapse.AbstractWeightedSynapse;

public class DefaultNeuron extends
		AbstractNeuron<Double, AbstractWeightedSynapse<?>> {

	private final AbstractWeightedSynapse<Double> biasSynapse = new AbstractWeightedSynapse<Double>(
			-1.0, 0.0) {
		@Override
		protected Double getValueFromInput(Double input) {
			return input;
		}
	};
	private IActivationFunction<Double, Double> activationFunction = new SigmoidFunction();

	public DefaultNeuron(Double initialValue) {
		super(initialValue);
		addSynapse(getBiasSynapse());
	}

	@Override
	protected Double computeValueFromInputs(
			Set<AbstractWeightedSynapse<?>> inputs) {
		Double value = 0.0;
		for (AbstractSynapse<?, Double> synapse : inputs) {
			value += synapse.getValue();
		}
		return activationFunction.compute(value);
	}

	public AbstractWeightedSynapse<Double> getBiasSynapse() {
		return biasSynapse;
	}

	public IActivationFunction<Double, Double> getActivationFunction() {
		return activationFunction;
	}

	public void setActivationFunction(
			IActivationFunction<Double, Double> activationFunction) {
		this.activationFunction = activationFunction;
	}
}
