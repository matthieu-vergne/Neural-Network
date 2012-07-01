package org.neuralnetwork.sample.booleanfunction;

import org.neuralnetwork.util.InputReader;

public class Input {
	boolean value = false;
	static InputReader<Input, Double> reader = new InputReader<Input, Double>() {

		@Override
		public Double readInput(Input input) {
			return input.value == true ? 1.0 : 0.0;
		}
	};
}
