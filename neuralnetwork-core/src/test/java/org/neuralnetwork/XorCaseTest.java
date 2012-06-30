package org.neuralnetwork;

import org.junit.Test;
import static org.junit.Assert.*;

import org.neuralnetwork.functions.HeavisideFunction;
import org.neuralnetwork.neuron.AbstractNeuron;
import org.neuralnetwork.neuron.DefaultNeuron;
import org.neuralnetwork.synapse.AbstractWeightedSynapse;

public class XorCaseTest {

	@Test
	public void testXorCase() {
		Input input1 = new Input();
		Input input2 = new Input();

		DefaultNeuron neuron1 = new DefaultNeuron(0.0) {
			@Override
			public String toString() {
				return "" + getValue();
			}
		};
		neuron1.setActivationFunction(new HeavisideFunction());
		neuron1.addSynapse(new InputSynapse(input1, 0.6));
		neuron1.addSynapse(new InputSynapse(input2, 0.6));
		neuron1.getBiasSynapse().setWeight(1.0);

		DefaultNeuron neuron2 = new DefaultNeuron(0.0) {
			@Override
			public String toString() {
				return "" + getValue();
			}
		};
		neuron2.setActivationFunction(new HeavisideFunction());
		neuron2.addSynapse(new InputSynapse(input1, 1.0));
		neuron2.addSynapse(new InputSynapse(input2, 1.0));
		neuron2.addSynapse(new XorNeuronSynapse(neuron1, -2.0));
		neuron2.getBiasSynapse().setWeight(1.0);

		/*
		 * Process
		 */
		input1.value = false;
		input2.value = false;
		neuron1.computeValue();
		assertEquals(0, neuron1.getValue(), 0);
		neuron2.computeValue();
		assertEquals(0, neuron2.getValue(), 0);

		input1.value = false;
		input2.value = true;
		neuron1.computeValue();
		assertEquals(0, neuron1.getValue(), 0);
		neuron2.computeValue();
		assertEquals(1, neuron2.getValue(), 0);

		input1.value = true;
		input2.value = false;
		neuron1.computeValue();
		assertEquals(0, neuron1.getValue(), 0);
		neuron2.computeValue();
		assertEquals(1, neuron2.getValue(), 0);

		input1.value = true;
		input2.value = true;
		neuron1.computeValue();
		assertEquals(1, neuron1.getValue(), 0);
		neuron2.computeValue();
		assertEquals(0, neuron2.getValue(), 0);
	}

	class Input {
		boolean value = false;

		@Override
		public String toString() {
			return "" + value;
		}
	}

	class InputSynapse extends AbstractWeightedSynapse<Input> {

		public InputSynapse(Input input, Double initialWeight) {
			super(input, initialWeight);
		}

		@Override
		protected Double getValueFromInput(Input input) {
			return input.value == true ? 1.0 : 0.0;
		}

	}

	class XorNeuronSynapse extends
			AbstractWeightedSynapse<AbstractNeuron<Double, ?>> {

		public XorNeuronSynapse(AbstractNeuron<Double, ?> input,
				Double initialWeight) {
			super(input, initialWeight);
		}

		@Override
		protected Double getValueFromInput(AbstractNeuron<Double, ?> input) {
			return input.getValue();
		}

	}
}
