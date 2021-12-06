package com.omarassadi.adventofcode;

import com.google.common.collect.Iterators;
import com.omarassadi.adventofcode.day.day5.Day5;
import com.omarassadi.adventofcode.day.day5.Path;
import com.omarassadi.adventofcode.day.day5.PathInputParser;
import com.omarassadi.adventofcode.util.io.input.resolver.InputResolver;
import com.omarassadi.adventofcode.util.math.Vector2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day5Test {

    private final List<String> exampleInput = """
        0,9 -> 5,9
        8,0 -> 0,8
        9,4 -> 3,4
        2,2 -> 2,1
        7,0 -> 7,4
        6,4 -> 2,0
        0,9 -> 2,9
        3,4 -> 1,4
        0,0 -> 8,8
        5,5 -> 8,2
        """.stripLeading().lines().toList();

    private final List<Path> exampleParsedInput = List.of(
        new Path(new Vector2(0, 9), new Vector2(5, 9)),
        new Path(new Vector2(8, 0), new Vector2(0, 8)),
        new Path(new Vector2(9, 4), new Vector2(3, 4)),
        new Path(new Vector2(2, 2), new Vector2(2, 1)),
        new Path(new Vector2(7, 0), new Vector2(7, 4)),
        new Path(new Vector2(6, 4), new Vector2(2, 0)),
        new Path(new Vector2(0, 9), new Vector2(2, 9)),
        new Path(new Vector2(3, 4), new Vector2(1, 4)),
        new Path(new Vector2(0, 0), new Vector2(8, 8)),
        new Path(new Vector2(5, 5), new Vector2(8, 2))
    );

    private final InputResolver dummyInputResolver = day -> exampleInput.stream();

    @Test
    void partOneSolution_should_return_5() {
        final Day5 day5 = new Day5(new PathInputParser());
        assertEquals(5, day5.getSolutions().get(0).solve(new PathInputParser().parse(exampleInput.stream())));
    }

    @Test
    void partTwoSolution_should_return_12() {
        final Day5 day5 = new Day5(new PathInputParser());
        assertEquals(12, day5.getSolutions().get(1).solve(new PathInputParser().parse(exampleInput.stream())));
    }

    @Test
    void solve_should_equal_5And12() {
        final Day5 day5 = new Day5(new PathInputParser());
        assertEquals(List.of(5L, 12L), day5.solve(dummyInputResolver));
    }

    @Test
    void parse_should_return_exampleInput() {
        final Day5 day5 = new Day5(new PathInputParser());
        assertTrue(Iterators.elementsEqual(exampleParsedInput.iterator(),
            day5.getInputParser().parse(exampleInput.stream()).iterator()));
    }
}
