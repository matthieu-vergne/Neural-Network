package org.neuralnetwork.synapse;

import static org.junit.Assert.*;

import org.junit.Test;
import org.neuralnetwork.synapse.AbstractSynapse;

public class AbstractSynapseTest {

	@Test
	public void testValueForFloor() {
		AbstractSynapse<Float,Integer> synapse = new AbstractSynapse<Float, Integer>(3.2f) {
			@Override
			protected Integer readValueFrom(Float input) {
				return (int) Math.floor(input);
			}
		};
		assertEquals(3, synapse.getValue().intValue());
	}

}
