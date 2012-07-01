package org.neuralnetwork.sample.booleanfunction;

import org.neuralnetwork.neuron.DefaultNeuron;
import org.neuralnetwork.synapse.SynapseFactory;

public class BooleanNot {

	public static void main(String[] args) {
		Input input = new Input();

		DefaultNeuron neuron = new DefaultNeuron(0.0);
		neuron.addSynapse(SynapseFactory.produceWeightedSynapse(input, -1.0,
				Input.reader));
		neuron.setBiasSynapseWeight(0.0);

		for (boolean a : new Boolean[] { false, true }) {
			input.value = a;
			neuron.computeValue();
			boolean result = neuron.getValue() >= 0.5;
			System.out.println(a + "=" + result);
		}
	}

}
