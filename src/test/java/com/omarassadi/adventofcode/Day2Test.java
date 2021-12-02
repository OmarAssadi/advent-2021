package com.omarassadi.adventofcode;

import com.omarassadi.adventofcode.day.day2.Day2;
import com.omarassadi.adventofcode.day.day2.MovementInputParser;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2Test {

    private final List<String> exampleInput = List.of(
        "forward 5",
        "down 5",
        "forward 8",
        "up 3",
        "down 8",
        "forward 2"
    );

    private final List<Pair<String, Long>> exampleParsedInput = List.of(
        new Pair<>("forward", 5L),
        new Pair<>("down", 5L),
        new Pair<>("forward", 8L),
        new Pair<>("up", 3L),
        new Pair<>("down", 8L),
        new Pair<>("forward", 2L)
    );

    @Test
    void partOneSolution_should_return_150() {
        final Day2 day2 = new Day2(new MovementInputParser());
        assertEquals(150, day2.getSolutions().get(0).solve(exampleParsedInput));
    }

    @Test
    void partTwoSolution_should_return_900() {
        final Day2 day2 = new Day2(new MovementInputParser());
        assertEquals(900, day2.getSolutions().get(1).solve(exampleParsedInput));
    }

    @Test
    void solve_should_equal_150And900() {
        final Day2 day2 = new Day2(new MovementInputParser());
        assertEquals(List.of(150L, 900L), day2.solve(exampleParsedInput));
    }

    @Test
    void parse_should_return_exampleInput() {
        final Day2 day2 = new Day2(new MovementInputParser());
        assertEquals(exampleParsedInput, day2.parseInput(exampleInput));
    }
}
