package org.neuralnetwork.synapse;

import static org.junit.Assert.*;

import org.junit.Test;

public class AbstractWeightProductSynapseTest {

	@Test
	public void test() {
		AbstractWeightProductSynapse<Double> synapse = new AbstractWeightProductSynapse<Double>(1.5, 0.0) {
			@Override
			protected Double getValueFromInput(Double input) {
				return input;
			}
		};
		assertEquals(0, synapse.getValue().doubleValue(), 0);
		synapse.setWeight(1.0);
		assertEquals(1.5, synapse.getValue().doubleValue(), 0);
		synapse.setWeight(10.0);
		assertEquals(15, synapse.getValue().doubleValue(), 0);
	}

}
