package org.neuralnetwork.neuron;

import static org.junit.Assert.*;

import org.junit.Test;
import org.neuralnetwork.functions.AbstractActivationFunction;
import org.neuralnetwork.functions.HeavisideFunction;
import org.neuralnetwork.functions.SigmoidFunction;

public class DefaultNeuronTest {

	@Test
	public void testSetGetActivationFunction() {
		DefaultNeuron neuron = new DefaultNeuron(0.0);
		AbstractActivationFunction<Double, Double> function = neuron
				.getActivationFunction();
		assertTrue(function instanceof SigmoidFunction);
		assertEquals(1, ((SigmoidFunction) function).getLambda(), 0);

		function = new HeavisideFunction();
		neuron.setActivationFunction(function);
		assertEquals(function, neuron.getActivationFunction());

		function = new AbstractActivationFunction<Double, Double>() {
			@Override
			public Double compute(Double input) {
				return input;
			}
		};
		neuron.setActivationFunction(function);
		assertEquals(function, neuron.getActivationFunction());
	}

	@Test
	public void testThreshold() {
		DefaultNeuron neuron = new DefaultNeuron(0.0);
		assertEquals(0, neuron.getThreshold(), 0);

		neuron.setThreshold(1);
		assertEquals(1, neuron.getThreshold(), 0);

		neuron.setThreshold(-5);
		assertEquals(-5, neuron.getThreshold(), 0);
	}

	class InputTest {
		double value = 0;
	}
}
