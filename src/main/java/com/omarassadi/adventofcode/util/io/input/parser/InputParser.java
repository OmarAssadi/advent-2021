package com.omarassadi.adventofcode.util.io.input.parser;

import java.util.stream.Stream;

@FunctionalInterface
public interface InputParser<T> {

    T parse(final Stream<String> input);
}
