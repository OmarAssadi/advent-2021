package com.omarassadi.adventofcode;

import com.omarassadi.adventofcode.day.day1.Day1;
import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Test {

    private final List<Long> exampleInput = List.of(
        199L,
        200L,
        208L,
        210L,
        200L,
        207L,
        240L,
        269L,
        260L,
        263L
    );

    private final InputParser<List<Long>> parser = input -> exampleInput;

    @Test
    void partOneSolution_should_return_7() {
        final Day1 day1 = new Day1(parser);
        assertEquals(7, day1.partOneSolution().solve(exampleInput));
    }

    @Test
    void partTwoSolution_should_return_5() {
        final Day1 day1 = new Day1(parser);
        assertEquals(5, day1.partTwoSolution().solve(exampleInput));
    }

    @Test
    void solve_should_equal_7And5() {
        final Day1 day1 = new Day1(parser);
        assertEquals(List.of(7L, 5L), day1.solve(exampleInput));
    }

    @Test
    void parse_should_return_exampleInput() {
        final Day1 day1 = new Day1(parser);
        assertEquals(exampleInput, day1.parseInput(exampleInput.stream().map(String::valueOf).toList()));
    }
}
