package org.neuralnetwork.synapse;

import static org.junit.Assert.*;

import org.junit.Test;
import org.neuralnetwork.synapse.AbstractWeightedSynapse;

public class AbstractWeightedSynapseTest {

	@Test
	public void testWeight() {
		AbstractWeightedSynapse<Double,Double,Integer> synapse = new AbstractWeightedSynapse<Double, Double, Integer>(3.2, 1) {
			@Override
			protected Double readValueFrom(Double input, Integer weight) {
				return 0.0;
			}
		};
		assertEquals(1, synapse.getWeight().intValue());
		synapse.setWeight(2);
		assertEquals(2, synapse.getWeight().intValue());
		synapse.setWeight(0);
		assertEquals(0, synapse.getWeight().intValue());
	}

	@Test
	public void testValueForProduct() {
		AbstractWeightedSynapse<Double,Double,Integer> synapse = new AbstractWeightedSynapse<Double, Double, Integer>(3.2, 1) {
			@Override
			protected Double readValueFrom(Double input, Integer weight) {
				return input * weight;
			}
		};
		assertEquals(3.2, synapse.getValue().doubleValue(), 0);
		synapse.setWeight(2);
		assertEquals(6.4, synapse.getValue().doubleValue(), 0);
		synapse.setWeight(0);
		assertEquals(0, synapse.getValue().doubleValue(), 0);
	}

}
