package com.omarassadi.adventofcode.util.io.input.parser;

import java.util.Collection;

@FunctionalInterface
public interface InputParser<T> {

    T parse(final Collection<String> input);
}
