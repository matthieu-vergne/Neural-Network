package org.neuralnetwork.util;

public interface InputReader<Input, Value> {

	public Value readInput(Input input);
}
