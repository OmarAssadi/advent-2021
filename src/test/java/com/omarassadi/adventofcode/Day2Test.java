package com.omarassadi.adventofcode;

import com.google.common.collect.Iterators;
import com.omarassadi.adventofcode.day.day2.Command;
import com.omarassadi.adventofcode.day.day2.CommandInputParser;
import com.omarassadi.adventofcode.day.day2.Day2;
import com.omarassadi.adventofcode.util.io.input.resolver.InputResolver;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day2Test {

    private final List<String> exampleInput = List.of(
        "forward 5",
        "down 5",
        "forward 8",
        "up 3",
        "down 8",
        "forward 2"
    );

    private final List<Command> exampleParsedInput = List.of(
        new Command.Forward(5),
        new Command.Down(5),
        new Command.Forward(8),
        new Command.Up(3),
        new Command.Down(8),
        new Command.Forward(2)
    );

    private final InputResolver dummyInputResolver = day -> exampleInput.stream();

    @Test
    void partOneSolution_should_return_150() {
        final Day2 day2 = new Day2(new CommandInputParser());
        assertEquals(150, day2.getSolutions().get(0).solve(exampleParsedInput.stream()));
    }

    @Test
    void partTwoSolution_should_return_900() {
        final Day2 day2 = new Day2(new CommandInputParser());
        assertEquals(900, day2.getSolutions().get(1).solve(exampleParsedInput.stream()));
    }

    @Test
    void solve_should_equal_150And900() {
        final Day2 day2 = new Day2(new CommandInputParser());
        assertEquals(List.of(150L, 900L), day2.solve(dummyInputResolver));
    }

    @Test
    void parse_should_return_exampleInput() {
        final Day2 day2 = new Day2(new CommandInputParser());
        assertTrue(Iterators.elementsEqual(exampleParsedInput.iterator(),
            day2.getInputParser().parse(exampleInput.stream()).iterator()));
    }
}
