package com.omarassadi.adventofcode;

import com.omarassadi.adventofcode.day.day3.Day3;
import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import com.omarassadi.adventofcode.util.io.input.resolver.InputResolver;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3Test {

    private final List<String> exampleInput = List.of(
        "00100",
        "11110",
        "10110",
        "10111",
        "10101",
        "01111",
        "00111",
        "11100",
        "10000",
        "11001",
        "00010",
        "01010"
    );

    private final InputParser<Stream<String>> dummyParser = input -> exampleInput.stream();

    private final InputResolver dummyInputResolver = day -> exampleInput.stream();

    @Test
    void partOneSolution_should_return_198() {
        final Day3 day3 = new Day3(dummyParser);
        assertEquals(198, day3.getSolutions().get(0).solve(exampleInput.stream()));
    }

    @Test
    void partTwoSolution_should_return_230() {
        final Day3 day3 = new Day3(dummyParser);
        assertEquals(230, day3.getSolutions().get(1).solve(exampleInput.stream()));
    }

    @Test
    void solve_should_equal_198And230() {
        final Day3 day3 = new Day3(dummyParser);
        assertEquals(List.of(198L, 230L), day3.solve(dummyInputResolver));
    }
}
