package com.omarassadi.adventofcode.day.day7;

import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;
@Component
public class CrabInputParser implements InputParser<List<Long>> {
    @Override
    public List<Long> parse(final Stream<String> input) {
        return StreamEx.of(input).flatMap(line -> Arrays.stream(line.split(","))
                .filter(not(String::isBlank)).map(Long::parseLong)).toList();
    }
}
