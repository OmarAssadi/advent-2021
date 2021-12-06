package com.omarassadi.adventofcode;

import com.omarassadi.adventofcode.day.day6.Day6;
import com.omarassadi.adventofcode.day.day6.LanternFishInputParser;
import com.omarassadi.adventofcode.util.io.input.resolver.InputResolver;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day6Test {

    private final String exampleInput = "3,4,3,1,2";

    private final long[] exampleParsedInput = new long[]{0, 1, 1, 2, 1, 0, 0, 0, 0};

    private final InputResolver dummyInputResolver = day -> Stream.of(exampleInput);

    @Test
    void partOneSolution_should_return_5934() {
        final Day6 day6 = new Day6(new LanternFishInputParser());
        assertEquals(5934, day6.getSolutions().get(0).solve(new LanternFishInputParser().parse(Stream.of(exampleInput))));
    }

    @Test
    void partTwoSolution_should_return_26984457539() {
        final Day6 day6 = new Day6(new LanternFishInputParser());
        assertEquals(26984457539L, day6.getSolutions().get(1).solve(new LanternFishInputParser().parse(Stream.of(exampleInput))));
    }

    @Test
    void solve_should_equal_5934And26984457539() {
        final Day6 day6 = new Day6(new LanternFishInputParser());
        assertEquals(List.of(5934L, 26984457539L), day6.solve(dummyInputResolver));
    }

    @Test
    void parse_should_return_exampleInput() {
        final Day6 day6 = new Day6(new LanternFishInputParser());
        assertArrayEquals(exampleParsedInput, day6.getInputParser().parse(Stream.of(exampleInput)));
    }
}
