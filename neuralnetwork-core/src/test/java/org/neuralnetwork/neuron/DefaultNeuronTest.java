package org.neuralnetwork.neuron;

import static org.junit.Assert.*;

import org.junit.Test;
import org.neuralnetwork.functions.IActivationFunction;
import org.neuralnetwork.functions.HeavisideFunction;
import org.neuralnetwork.functions.SigmoidFunction;
import org.neuralnetwork.synapse.AbstractWeightedSynapse;

public class DefaultNeuronTest {

	@Test
	public void testBiasSynapse() {
		DefaultNeuron neuron = new DefaultNeuron(0.0);
		AbstractWeightedSynapse<Double> biasSynapse = neuron
				.getBiasSynapse();
		assertEquals(0, biasSynapse.getWeight(), 0);
		biasSynapse.setWeight(1.0);
		assertEquals(-1, biasSynapse.getValue(), 0);
	}

	@Test
	public void testSetGetActivationFunction() {
		DefaultNeuron neuron = new DefaultNeuron(0.0);
		IActivationFunction<Double, Double> function = neuron
				.getActivationFunction();
		assertTrue(function instanceof SigmoidFunction);
		assertEquals(1, ((SigmoidFunction) function).getLambda(), 0);

		function = new HeavisideFunction();
		neuron.setActivationFunction(function);
		assertEquals(function, neuron.getActivationFunction());

		function = new IActivationFunction<Double, Double>() {
			@Override
			public Double compute(Double input) {
				return input;
			}
		};
		neuron.setActivationFunction(function);
		assertEquals(function, neuron.getActivationFunction());
	}

	@Test
	public void testActivationFunctionValue() {
		DefaultNeuron neuron = new DefaultNeuron(0.0);
		neuron.setActivationFunction(new IActivationFunction<Double, Double>() {
			@Override
			public Double compute(Double input) {
				return input > 1.0 && input < 2.0 ? 1.0 : 0.0;
			}
		});
		InputTest input = new InputTest();
		neuron.addSynapse(new AbstractWeightedSynapse<InputTest>(input,
				2.0) {
			@Override
			protected Double getValueFromInput(InputTest input) {
				return input.value;
			}
		});

		input.value = -50;
		neuron.computeValue();
		assertEquals(0, neuron.getValue(), 0);

		input.value = 0;
		neuron.computeValue();
		assertEquals(0, neuron.getValue(), 0);

		input.value = 0.4;
		neuron.computeValue();
		assertEquals(0, neuron.getValue(), 0);

		input.value = 0.5;
		neuron.computeValue();
		assertEquals(0, neuron.getValue(), 0);

		input.value = 0.6;
		neuron.computeValue();
		assertEquals(1, neuron.getValue(), 0);

		input.value = 0.9;
		neuron.computeValue();
		assertEquals(1, neuron.getValue(), 0);

		input.value = 1;
		neuron.computeValue();
		assertEquals(0, neuron.getValue(), 0);
	}

	class InputTest {
		double value = 0;
	}
}
