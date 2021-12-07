package com.omarassadi.adventofcode;

import com.omarassadi.adventofcode.day.day7.Day7;
import com.omarassadi.adventofcode.day.day7.CrabInputParser;
import com.omarassadi.adventofcode.util.io.input.resolver.InputResolver;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day7Test {

    private final String exampleInput = "16,1,2,0,4,2,7,1,2,14";

    private final List<Long> exampleParsedInput = List.of(16L, 1L, 2L, 0L, 4L, 2L, 7L, 1L, 2L, 14L);

    private final InputResolver dummyInputResolver = day -> Stream.of(exampleInput);

    @Test
    void partOneSolution_should_return_37() {
        final Day7 day7 = new Day7(new CrabInputParser());
        assertEquals(37, day7.getSolutions().get(0).solve(new CrabInputParser().parse(Stream.of(exampleInput))));
    }

    @Test
    void partTwoSolution_should_return_168() {
        final Day7 day7 = new Day7(new CrabInputParser());
        assertEquals(168, day7.getSolutions().get(1).solve(new CrabInputParser().parse(Stream.of(exampleInput))));
    }

    @Test
    void solve_should_equal_37And168() {
        final Day7 day7 = new Day7(new CrabInputParser());
        assertEquals(List.of(37L, 168L), day7.solve(dummyInputResolver));
    }

    @Test
    void parse_should_return_exampleInput() {
        final Day7 day7 = new Day7(new CrabInputParser());
        assertEquals(exampleParsedInput, day7.getInputParser().parse(Stream.of(exampleInput)));
    }
}
