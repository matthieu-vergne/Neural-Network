package org.neuralnetwork.neuron;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import org.neuralnetwork.synapse.AbstractSynapse;

public class AbstractNeuronTest {

	@Test
	public void testInitialValue() {
		int init = 0;
		AbstractNeuron<Integer, AbstractSynapse<?, ?>> neuron = new AbstractNeuron<Integer, AbstractSynapse<?, ?>>(
				init) {
			@Override
			protected Integer computeValueFromInputs(
					Set<AbstractSynapse<?, ?>> inputs) {
				return -1;
			}
		};
		assertEquals(init, neuron.getValue().intValue());
	}

	@Test
	public void testComputeValue() {
		AbstractNeuron<Integer, AbstractSynapse<?, ?>> neuron = new AbstractNeuron<Integer, AbstractSynapse<?, ?>>(
				0) {
			@Override
			protected Integer computeValueFromInputs(
					Set<AbstractSynapse<?, ?>> inputs) {
				return getValue() + 1;
			}
		};
		assertEquals(0, neuron.getValue().intValue());
		neuron.computeValue();
		assertEquals(1, neuron.getValue().intValue());
		neuron.computeValue();
		assertEquals(2, neuron.getValue().intValue());
	}

	@Test
	public void testAddRemoveSynapse() {
		AbstractNeuron<?, AbstractSynapse<?, ?>> neuron = new AbstractNeuron<Object, AbstractSynapse<?, ?>>(
				null) {
			@Override
			protected Object computeValueFromInputs(
					Set<AbstractSynapse<?, ?>> inputs) {
				return null;
			}
		};

		SynapseTest synapse1 = new SynapseTest(0);
		SynapseTest synapse2 = new SynapseTest(1);
		SynapseTest synapse3 = new SynapseTest(2);

		{
			Set<AbstractSynapse<?, ?>> synapses = neuron.getSynapses();
			assertEquals(0, synapses.size());
			assertFalse(synapses.contains(synapse1));
			assertFalse(synapses.contains(synapse2));
			assertFalse(synapses.contains(synapse3));
		}

		neuron.addSynapse(synapse1);
		{
			Set<AbstractSynapse<?, ?>> synapses = neuron.getSynapses();
			assertEquals(1, synapses.size());
			assertTrue(synapses.contains(synapse1));
			assertFalse(synapses.contains(synapse2));
			assertFalse(synapses.contains(synapse3));
		}

		// check no double add
		neuron.addSynapse(synapse1);
		{
			Set<AbstractSynapse<?, ?>> synapses = neuron.getSynapses();
			assertEquals(1, synapses.size());
			assertTrue(synapses.contains(synapse1));
			assertFalse(synapses.contains(synapse2));
			assertFalse(synapses.contains(synapse3));
		}

		neuron.addSynapse(synapse2);
		{
			Set<AbstractSynapse<?, ?>> synapses = neuron.getSynapses();
			assertEquals(2, synapses.size());
			assertTrue(synapses.contains(synapse1));
			assertTrue(synapses.contains(synapse2));
			assertFalse(synapses.contains(synapse3));
		}

		neuron.addSynapse(synapse3);
		{
			Set<AbstractSynapse<?, ?>> synapses = neuron.getSynapses();
			assertEquals(3, synapses.size());
			assertTrue(synapses.contains(synapse1));
			assertTrue(synapses.contains(synapse2));
			assertTrue(synapses.contains(synapse3));
		}

		neuron.removeSynapse(synapse2);
		{
			Set<AbstractSynapse<?, ?>> synapses = neuron.getSynapses();
			assertEquals(2, synapses.size());
			assertTrue(synapses.contains(synapse1));
			assertFalse(synapses.contains(synapse2));
			assertTrue(synapses.contains(synapse3));
		}

		// check no double remove
		neuron.removeSynapse(synapse2);
		{
			Set<AbstractSynapse<?, ?>> synapses = neuron.getSynapses();
			assertEquals(2, synapses.size());
			assertTrue(synapses.contains(synapse1));
			assertFalse(synapses.contains(synapse2));
			assertTrue(synapses.contains(synapse3));
		}

		neuron.removeSynapse(synapse1);
		{
			Set<AbstractSynapse<?, ?>> synapses = neuron.getSynapses();
			assertEquals(1, synapses.size());
			assertFalse(synapses.contains(synapse1));
			assertFalse(synapses.contains(synapse2));
			assertTrue(synapses.contains(synapse3));
		}

		neuron.removeSynapse(synapse3);
		{
			Set<AbstractSynapse<?, ?>> synapses = neuron.getSynapses();
			assertEquals(0, synapses.size());
			assertFalse(synapses.contains(synapse1));
			assertFalse(synapses.contains(synapse2));
			assertFalse(synapses.contains(synapse3));
		}
	}

	class SynapseTest extends AbstractSynapse<Integer, Integer> {
		public SynapseTest(Integer input) {
			super(input);
		}

		@Override
		protected Integer readValueFrom(Integer input) {
			return input;
		}
	}
}
