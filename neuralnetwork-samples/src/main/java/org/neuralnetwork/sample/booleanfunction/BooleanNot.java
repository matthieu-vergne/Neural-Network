package org.neuralnetwork.sample.booleanfunction;

import org.neuralnetwork.neuron.DefaultNeuron;

public class BooleanNot {

	public static void main(String[] args) {
		Input input = new Input();

		DefaultNeuron neuron = new DefaultNeuron(0.0);
		neuron.addSynapse(new InputSynapse(input, -1.0));
		neuron.setBiasSynapseWeight(0.0);

		for (boolean a : new Boolean[] { false, true }) {
			input.value = a;
			neuron.computeValue();
			boolean result = neuron.getValue() >= 0.5;
			System.out.println(a + "=" + result);
		}
	}

}
