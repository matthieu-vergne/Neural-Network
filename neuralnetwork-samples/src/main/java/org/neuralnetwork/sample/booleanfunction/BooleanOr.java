package org.neuralnetwork.sample.booleanfunction;

import org.neuralnetwork.neuron.DefaultNeuron;
import org.neuralnetwork.synapse.SynapseFactory;

public class BooleanOr {

	public static void main(String[] args) {
		Input input1 = new Input();
		Input input2 = new Input();

		DefaultNeuron neuron = new DefaultNeuron(0.0);
		neuron.addSynapse(SynapseFactory.produceWeightedSynapse(input1, 1.0,
				Input.reader));
		neuron.addSynapse(SynapseFactory.produceWeightedSynapse(input2, 1.0,
				Input.reader));
		neuron.setBiasSynapseWeight(0.5);

		for (boolean b : new Boolean[] { false, true }) {
			for (boolean a : new Boolean[] { false, true }) {
				input1.value = a;
				input2.value = b;
				neuron.computeValue();
				boolean result = neuron.getValue() >= 0.5;
				System.out.println(a + "+" + b + "=" + result);
			}
		}
	}

}
