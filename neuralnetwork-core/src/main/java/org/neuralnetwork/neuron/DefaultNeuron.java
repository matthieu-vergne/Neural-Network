package org.neuralnetwork.neuron;

import java.util.Set;

import org.neuralnetwork.functions.IActivationFunction;
import org.neuralnetwork.functions.SigmoidFunction;
import org.neuralnetwork.synapse.ISynapse;
import org.neuralnetwork.synapse.SynapseFactory;
import org.neuralnetwork.util.DirectValueReader;

public class DefaultNeuron extends AbstractNeuron<Double, ISynapse<?, Double>> {

	private ISynapse<Double, Double> biasSynapse;
	private IActivationFunction<Double, Double> activationFunction = new SigmoidFunction();

	public DefaultNeuron(Double initialValue) {
		super(initialValue);
		setBiasSynapseWeight(0.0);
	}

	@Override
	protected Double computeValueFromInputs(Set<ISynapse<?, Double>> inputs) {
		Double value = 0.0;
		for (ISynapse<?, Double> synapse : inputs) {
			value += synapse.getValue();
		}
		return activationFunction.compute(value);
	}

	public void setBiasSynapseWeight(Double weight) {
		if (biasSynapse != null) {
			removeSynapse(biasSynapse);
		}
		biasSynapse = SynapseFactory.produceWeightedSynapse(-1.0, weight,
				new DirectValueReader<Double>());
		addSynapse(biasSynapse);
	}

	public IActivationFunction<Double, Double> getActivationFunction() {
		return activationFunction;
	}

	public void setActivationFunction(
			IActivationFunction<Double, Double> activationFunction) {
		this.activationFunction = activationFunction;
	}
}
