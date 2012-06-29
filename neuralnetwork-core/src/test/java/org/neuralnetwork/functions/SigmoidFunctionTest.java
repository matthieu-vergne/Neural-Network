package org.neuralnetwork.functions;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class SigmoidFunctionTest {

	@Test
	public void testLambda() {
		assertEquals(1, new SigmoidFunction().getLambda(), 0);

		assertEquals(1, new SigmoidFunction(1).getLambda(), 0);
		assertEquals(2, new SigmoidFunction(2).getLambda(), 0);
		assertEquals(-3, new SigmoidFunction(-3).getLambda(), 0);
	}

	@Test
	public void testComputationForLambda1() {
		SigmoidFunction function = new SigmoidFunction();
		assertEquals(0.5, function.compute(0.0), 0);
		assertEquals(0, function.compute(Double.NEGATIVE_INFINITY), 0);
		assertEquals(1, function.compute(Double.POSITIVE_INFINITY), 0);
		// FIXME add values
	}

	@Test
	public void testComputationForLambdaInfinite() {
		SigmoidFunction function = new SigmoidFunction(Double.POSITIVE_INFINITY);
		HeavisideFunction equivalent = new HeavisideFunction(0);
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			double value = (rand.nextDouble() - 0.5) * 1000;
			assertEquals(equivalent.compute(value), function.compute(value), 0);
		}
	}

}
