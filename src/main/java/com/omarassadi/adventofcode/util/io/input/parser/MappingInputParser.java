package com.omarassadi.adventofcode.util.io.input.parser;

import one.util.streamex.StreamEx;

import java.util.function.Function;
import java.util.stream.Stream;

public class MappingInputParser<T> implements InputParser<Stream<T>> {

    private final Function<String, T> mapper;

    public MappingInputParser(final Function<String, T> mapper) {
        this.mapper = mapper;
    }

    @Override
    public Stream<T> parse(final Stream<String> input) {
        return StreamEx.of(input).map(mapper);
    }
}
