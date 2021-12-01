package com.omarassadi.adventofcode.util.io.input.parser;

import one.util.streamex.StreamEx;
import org.springframework.cache.annotation.Cacheable;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class MappingInputParser<T> implements InputParser<List<T>> {

    private final Function<String, T> mapper;

    public MappingInputParser(final Function<String, T> mapper) {
        this.mapper = mapper;
    }

    @Override
    @Cacheable("puzzleInput")
    public List<T> parse(final Collection<String> input) {
        return StreamEx.of(input).map(mapper).toList();
    }
}
