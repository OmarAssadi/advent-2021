package com.omarassadi.adventofcode.day.day5;

import com.omarassadi.adventofcode.day.Day;
import com.omarassadi.adventofcode.day.PuzzleSolution;
import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import one.util.streamex.LongStreamEx;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Day5 extends Day<Stream<Path>, Long> {

    public Day5(final InputParser<Stream<Path>> inputParser) {
        super(5, inputParser);
    }

    @Override
    public List<PuzzleSolution<Stream<Path>, Long>> getSolutions() {
        return List.of(partOneSolution(), partTwoSolution());
    }

    private PuzzleSolution<Stream<Path>, Long> partOneSolution() {
        return input -> solution(path -> path.start().x() == path.end().x()
            || path.start().y() == path.end().y()).solve(input);
    }

    private PuzzleSolution<Stream<Path>, Long> partTwoSolution() {
        return input -> solution(path -> true).solve(input);
    }

    private PuzzleSolution<Stream<Path>, Long> solution(final Predicate<Path> takePath) {
        return input -> LongStreamEx.of(StreamEx.of(input).filter(takePath)
                .flatMap(path -> StreamEx.of(path.getSteps()))
                .groupingBy(Function.identity(), Collectors.counting()).values())
            .greater(1).count();
    }
}
