package org.neuralnetwork.util;

import org.neuralnetwork.neuron.INeuron;

public class DirectNeuronReader<Value> implements
		InputReader<INeuron<Value, ?>, Value> {

	@Override
	public Value readInput(INeuron<Value, ?> neuron) {
		return neuron.getValue();
	}

}
