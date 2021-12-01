package com.omarassadi.adventofcode.day;

import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import com.omarassadi.adventofcode.util.io.input.resolver.InputResolver;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import org.springframework.util.StopWatch;

import java.util.Collection;
import java.util.stream.IntStream;

@Slf4j
public abstract class Day<T, V> {

    private final int day;
    private final InputParser<T> inputParser;

    protected Day(final int day, final InputParser<T> inputParser) {
        this.day = day;
        this.inputParser = inputParser;
    }

    public int getDay() {
        return day;
    }

    public Collection<V> solve(final InputResolver resolver) {
        return solve(parseInput(resolver.resolve(day)));
    }

    public Collection<V> solve(final T input) {
        final Collection<PuzzleSolution<T, V>> solutions = getSolutions();
        final StopWatch stopWatch = new StopWatch("Day %d".formatted(day));
        final Collection<V> results = StreamEx.of(solutions).zipWith(IntStream.rangeClosed(1, solutions.size())).map(solution -> {
            stopWatch.start("Part %d Solution".formatted(solution.getValue()));
            final V result = solution.getKey().solve(input);
            stopWatch.stop();
            return result;
        }).toList();
        log.info(stopWatch.prettyPrint());
        return results;
    }

    public final T parseInput(final Collection<String> input) {
        return inputParser.parse(input);
    }

    public abstract Collection<PuzzleSolution<T, V>> getSolutions();
}
