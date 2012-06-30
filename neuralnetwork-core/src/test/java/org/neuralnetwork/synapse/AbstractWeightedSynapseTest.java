package org.neuralnetwork.synapse;

import static org.junit.Assert.*;

import org.junit.Test;

public class AbstractWeightedSynapseTest {

	@Test
	public void testWeight() {
		AbstractWeightedSynapse<Double> synapse = new AbstractWeightedSynapse<Double>(
				3.2, 1.0) {
			@Override
			protected Double getValueFromInput(Double input) {
				return 0.0;
			}
		};
		assertEquals(1, synapse.getWeight().intValue());
		synapse.setWeight(2.0);
		assertEquals(2, synapse.getWeight().intValue());
		synapse.setWeight(0.0);
		assertEquals(0, synapse.getWeight().intValue());
	}

	@Test
	public void testValue() {
		AbstractWeightedSynapse<Double> synapse = new AbstractWeightedSynapse<Double>(
				1.5, 0.0) {
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
