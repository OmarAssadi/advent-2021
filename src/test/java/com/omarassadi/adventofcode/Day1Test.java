package com.omarassadi.adventofcode;

import com.omarassadi.adventofcode.day.day1.Day1;
import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import com.omarassadi.adventofcode.util.io.input.resolver.InputResolver;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Test {

    private final List<String> exampleInput = List.of(
        "199",
        "200",
        "208",
        "210",
        "200",
        "207",
        "240",
        "269",
        "260",
        "263"
    );

    private final InputParser<LongStream> parser = input -> exampleInput.stream().mapToLong(Long::parseLong);

    private final InputResolver dummyInputResolver = day -> exampleInput.stream().map(String::valueOf);

    @Test
    void partOneSolution_should_return_7() {
        final Day1 day1 = new Day1(parser);
        assertEquals(7, day1.partOneSolution().solve(exampleInput.stream().mapToLong(Long::parseLong)));
    }

    @Test
    void partTwoSolution_should_return_5() {
        final Day1 day1 = new Day1(parser);
        assertEquals(5, day1.partTwoSolution().solve(exampleInput.stream().mapToLong(Long::parseLong)));
    }

    @Test
    void solve_should_equal_7And5() {
        final Day1 day1 = new Day1(parser);
        assertEquals(List.of(7L, 5L), day1.solve(dummyInputResolver));
    }
}
