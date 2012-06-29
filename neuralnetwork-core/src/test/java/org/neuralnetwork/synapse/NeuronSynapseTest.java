package org.neuralnetwork.synapse;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import org.neuralnetwork.neuron.AbstractNeuron;

public class NeuronSynapseTest {

	@Test
	public void test() {
		AbstractNeuron<Integer, NeuronSynapse<Integer>> inputNeuron = new AbstractNeuron<Integer, NeuronSynapse<Integer>>(
				0) {
			@Override
			protected Integer computeValueFromInputs(
					Set<NeuronSynapse<Integer>> inputs) {
				return getValue() + 1;
			}
		};
		NeuronSynapse<Integer> synapse = new NeuronSynapse<Integer>(inputNeuron);
		assertEquals(0, synapse.getValue().intValue());
		inputNeuron.computeValue();
		assertEquals(1, synapse.getValue().intValue());
		inputNeuron.computeValue();
		assertEquals(2, synapse.getValue().intValue());
	}

}
