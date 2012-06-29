package org.neuralnetwork.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeavisideFunctionTest {

	@Test
	public void testThreshold() {
		assertEquals(0, new HeavisideFunction().getThreshold(), 0);

		assertEquals(0, new HeavisideFunction(0).getThreshold(), 0);
		assertEquals(1, new HeavisideFunction(1).getThreshold(), 0);
		assertEquals(-3, new HeavisideFunction(-3).getThreshold(), 0);
	}

	@Test
	public void testComputationForThreshold0() {
		HeavisideFunction function = new HeavisideFunction();
		assertEquals(0, function.compute(-10.0), 0);
		assertEquals(0, function.compute(-1.0), 0);
		assertEquals(0, function.compute(-0.1), 0);
		assertEquals(1, function.compute(0.0), 0);
		assertEquals(1, function.compute(0.1), 0);
		assertEquals(1, function.compute(1.0), 0);
		assertEquals(1, function.compute(10.0), 0);
	}

}
