package org.neuralnetwork.sample.booleanfunction;

import org.neuralnetwork.functions.HeavisideFunction;
import org.neuralnetwork.neuron.DefaultNeuron;
import org.neuralnetwork.synapse.SynapseFactory;
import org.neuralnetwork.util.DirectNeuronReader;

public class BooleanXor {

	public static void main(String[] args) {
		Input input1 = new Input();
		Input input2 = new Input();

		DefaultNeuron neuron1 = new DefaultNeuron(0.0);
		neuron1.setActivationFunction(new HeavisideFunction());
		neuron1.addSynapse(SynapseFactory.produceWeightedSynapse(input1, 0.6,
				Input.reader));
		neuron1.addSynapse(SynapseFactory.produceWeightedSynapse(input2, 0.6,
				Input.reader));
		neuron1.setBiasSynapseWeight(1.0);

		DefaultNeuron neuron2 = new DefaultNeuron(0.0);
		neuron2.setActivationFunction(new HeavisideFunction());
		neuron2.addSynapse(SynapseFactory.produceWeightedSynapse(input1, 1.0,
				Input.reader));
		neuron2.addSynapse(SynapseFactory.produceWeightedSynapse(input2, 1.0,
				Input.reader));
		neuron2.addSynapse(SynapseFactory.produceNeuronWeightedSynapse(neuron1,
				-2.0, new DirectNeuronReader<Double>()));
		neuron2.setBiasSynapseWeight(1.0);

		for (boolean b : new Boolean[] { false, true }) {
			for (boolean a : new Boolean[] { false, true }) {
				input1.value = a;
				input2.value = b;
				neuron1.computeValue();
				neuron2.computeValue();
				boolean result = neuron2.getValue() >= 0.5;
				System.out.println(a + "+" + b + "=" + result);
			}
		}
	}

}
