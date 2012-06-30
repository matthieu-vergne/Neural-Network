package org.neuralnetwork.synapse;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import org.neuralnetwork.neuron.AbstractNeuron;
import org.neuralnetwork.neuron.INeuron;
import org.neuralnetwork.util.DirectValueReader;
import org.neuralnetwork.util.InputReader;

public class SynapseFactoryTest {

	@Test
	public void testNeuronSynapse() {
		AbstractNeuron<Integer, ISynapse<?, Integer>> neuron = new AbstractNeuron<Integer, ISynapse<?, Integer>>(
				0) {
			@Override
			protected Integer computeValueFromInputs(
					Set<ISynapse<?, Integer>> inputs) {
				return getValue() + 1;
			}
		};
		ISynapse<INeuron<Integer, ?>, Integer> synapse = SynapseFactory
				.produceNeuronSynapse(neuron);
		assertEquals(0, synapse.getValue().intValue());
		neuron.computeValue();
		assertEquals(1, synapse.getValue().intValue());
		neuron.computeValue();
		assertEquals(2, synapse.getValue().intValue());
	}

	@Test
	public void testWeightedSynapse() {
		{
			ISynapse<Double, Double> synapse = SynapseFactory
					.produceWeightedSynapse(1.5, 0.0,
							new DirectValueReader<Double>());
			assertEquals(0, synapse.getValue(), 0);
		}

		{
			ISynapse<Double, Double> synapse = SynapseFactory
					.produceWeightedSynapse(1.5, 1.0,
							new DirectValueReader<Double>());
			assertEquals(1.5, synapse.getValue().doubleValue(), 0);
		}

		{
			ISynapse<Double, Double> synapse = SynapseFactory
					.produceWeightedSynapse(1.5, 10.0,
							new DirectValueReader<Double>());
			assertEquals(15, synapse.getValue().doubleValue(), 0);
		}
	}

	@Test
	public void testNeuronWeightedSynapse() {
		AbstractNeuron<Integer, ISynapse<?, Integer>> neuron = new AbstractNeuron<Integer, ISynapse<?, Integer>>(
				5) {
			@Override
			protected Integer computeValueFromInputs(
					Set<ISynapse<?, Integer>> inputs) {
				return getValue();
			}
		};
		InputReader<INeuron<Integer, ?>, Double> reader = new InputReader<INeuron<Integer, ?>, Double>() {

			@Override
			public Double readInput(INeuron<Integer, ?> neuron) {
				return neuron.getValue().doubleValue();
			}
		};
		{
			ISynapse<INeuron<Integer, ?>, Double> synapse = SynapseFactory
					.produceNeuronWeightedSynapse(neuron, 0, reader);
			assertEquals(0, synapse.getValue(), 0);
		}

		{
			ISynapse<INeuron<Integer, ?>, Double> synapse = SynapseFactory
					.produceNeuronWeightedSynapse(neuron, 1, reader);
			assertEquals(5, synapse.getValue().doubleValue(), 0);
		}

		{
			ISynapse<INeuron<Integer, ?>, Double> synapse = SynapseFactory
					.produceNeuronWeightedSynapse(neuron, 10, reader);
			assertEquals(50, synapse.getValue().doubleValue(), 0);
		}
	}
}
