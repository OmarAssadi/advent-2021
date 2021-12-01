package com.omarassadi.adventofcode.day;

import com.omarassadi.adventofcode.util.LongStreamExUtil;
import com.omarassadi.adventofcode.util.StreamExUtil;
import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import lombok.experimental.ExtensionMethod;
import one.util.streamex.LongStreamEx;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@ExtensionMethod({StreamEx.class, StreamExUtil.class, LongStreamEx.class, LongStreamExUtil.class})
public class Day1 extends Day<List<Long>, Long> {

    public Day1(final InputParser<List<Long>> inputParser) {
        super(1, inputParser);
    }

    @Override
    public Collection<PuzzleSolution<List<Long>, Long>> getSolutions() {
        return List.of(
            partOneSolution(),
            partTwoSolution()
        );
    }

    public PuzzleSolution<List<Long>, Long> partOneSolution() {
        return input -> LongStreamEx.of(input).pairMap((a, b) -> b > a ? 1 : 0).sum();
    }

    public PuzzleSolution<List<Long>, Long> partTwoSolution() {
        return input -> partOneSolution().solve(StreamEx.of(input).windowed(3).map(i -> i.sum()).toList());
    }
}
