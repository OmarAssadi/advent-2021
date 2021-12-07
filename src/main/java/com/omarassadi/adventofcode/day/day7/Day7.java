package com.omarassadi.adventofcode.day.day7;

import com.omarassadi.adventofcode.day.Day;
import com.omarassadi.adventofcode.day.PuzzleSolution;
import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import one.util.streamex.LongStreamEx;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Component
public class Day7 extends Day<List<Long>, Long> {


    public Day7(final InputParser<List<Long>> inputParser) {
        super(7, inputParser);
    }

    @Override
    public Collection<PuzzleSolution<List<Long>, Long>> getSolutions() {
        return List.of(
            partOneSolution(),
            partTwoSolution()
        );
    }

    private PuzzleSolution<List<Long>, Long> solution(Function<Long, Long> distance) {
        return input -> LongStreamEx.of(input).max().stream().flatMap(LongStreamEx::range).map(pos ->
            input.stream().mapToLong(crab -> distance.apply(Math.abs(pos - crab))).sum()
        ).min().orElseThrow();
    }

    private PuzzleSolution<List<Long>, Long> partOneSolution() {
        return input -> solution(distance -> distance).solve(input);
    }

    private PuzzleSolution<List<Long>, Long> partTwoSolution() {
        return input -> solution(distance -> distance * (distance + 1) / 2).solve(input);
    }
}
