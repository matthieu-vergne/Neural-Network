package org.neuralnetwork.synapse;

import org.neuralnetwork.neuron.INeuron;
import org.neuralnetwork.util.InputReader;

public class SynapseFactory {

	static public <Value> ISynapse<INeuron<Value, ?>, Value> produceNeuronSynapse(
			final INeuron<Value, ?> neuron) {
		ISynapse<INeuron<Value, ?>, Value> synapse = new AbstractSynapse<INeuron<Value, ?>, Value>(
				neuron) {
			@Override
			protected Value readValueFrom(INeuron<Value, ?> input) {
				return input.getValue();
			}
		};
		return synapse;
	}

	static public <Input> ISynapse<Input, Double> produceWeightedSynapse(
			final Input input, final double weight,
			final InputReader<Input, Double> reader) {
		ISynapse<Input, Double> synapse = new AbstractSynapse<Input, Double>(
				input) {
			@Override
			protected Double readValueFrom(Input input) {
				return reader.readInput(input) * weight;
			}
		};
		return synapse;
	}

	static public <Value> ISynapse<INeuron<Value, ?>, Double> produceNeuronWeightedSynapse(
			final INeuron<Value, ?> neuron, final double weight,
			final InputReader<INeuron<Value, ?>, Double> reader) {
		return produceWeightedSynapse(neuron, weight, reader);
	}
}
