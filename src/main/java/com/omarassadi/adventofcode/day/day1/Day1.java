package com.omarassadi.adventofcode.day.day1;

import com.omarassadi.adventofcode.day.Day;
import com.omarassadi.adventofcode.day.PuzzleSolution;
import com.omarassadi.adventofcode.util.LongStreamExUtil;
import com.omarassadi.adventofcode.util.StreamExUtil;
import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import lombok.experimental.ExtensionMethod;
import one.util.streamex.LongStreamEx;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.LongStream;

@Component
@ExtensionMethod({StreamEx.class, StreamExUtil.class, LongStreamEx.class, LongStreamExUtil.class})
public class Day1 extends Day<LongStream, Long> {

    public Day1(final InputParser<LongStream> inputParser) {
        super(1, inputParser);
    }

    @Override
    public Collection<PuzzleSolution<LongStream, Long>> getSolutions() {
        return List.of(
            partOneSolution(),
            partTwoSolution()
        );
    }

    public PuzzleSolution<LongStream, Long> partOneSolution() {
        return input -> LongStreamEx.of(input).pairMap((a, b) -> b > a ? 1 : 0).sum();
    }

    public PuzzleSolution<LongStream, Long> partTwoSolution() {
        return input -> partOneSolution().solve(StreamEx.of(input.boxed().toList()).windowed(3)
            .map(i -> i.sum()).mapToLong(i -> i));
    }
}
