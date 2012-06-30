package org.neuralnetwork.util;

public class DirectValueReader<Value> implements InputReader<Value, Value> {

	public Value readInput(Value input) {
		return input;
	};
}
