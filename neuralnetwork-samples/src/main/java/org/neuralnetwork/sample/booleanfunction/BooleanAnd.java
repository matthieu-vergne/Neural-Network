package org.neuralnetwork.sample.booleanfunction;

import org.neuralnetwork.neuron.DefaultNeuron;

public class BooleanAnd {

	public static void main(String[] args) {
		Input input1 = new Input();
		Input input2 = new Input();

		DefaultNeuron neuron = new DefaultNeuron(0.0);
		neuron.addSynapse(new InputSynapse(input1, 1.0));
		neuron.addSynapse(new InputSynapse(input2, 1.0));
		neuron.getBiasSynapse().setWeight(0.75);

		for (boolean b : new Boolean[] { false, true }) {
			for (boolean a : new Boolean[] { false, true }) {
				input1.value = a;
				input2.value = b;
				neuron.computeValue();
				boolean result = neuron.getValue() >= 0.75;
				System.out.println(a + "." + b + "=" + result);
			}
		}
	}

}
