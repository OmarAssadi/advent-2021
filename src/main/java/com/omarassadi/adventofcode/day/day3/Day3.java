package com.omarassadi.adventofcode.day.day3;

import com.omarassadi.adventofcode.day.Day;
import com.omarassadi.adventofcode.day.PuzzleSolution;
import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import javafx.util.Pair;
import one.util.streamex.IntStreamEx;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class Day3 extends Day<Stream<String>, Long> {

    public Day3(final InputParser<Stream<String>> inputParser) {
        super(3, inputParser);
    }

    @Override
    public List<PuzzleSolution<Stream<String>, Long>> getSolutions() {
        return List.of(partOneSolution(), partTwoSolution());
    }

    private long countOnes(final List<String> lines, final int index) {
        return lines.stream().mapToLong(l -> l.charAt(index) == '1' ? 1 : -1).sum();
    }

    private PuzzleSolution<Stream<String>, Long> partOneSolution() {
        return input -> {
            final var lines = input.toList();
            final var result = IntStreamEx.range(0, lines.get(0).length()).boxed()
                .map(index -> countOnes(lines, index))
                .foldLeft(new Pair<>(new StringBuilder(), new StringBuilder()), (acc, bit) -> {
                    acc.getKey().append(bit >= 0 ? '1' : '0');
                    acc.getValue().append(bit >= 0 ? '0' : '1');
                    return acc;
                });
            return Long.parseLong(result.getKey().toString(), 2) * Long.parseLong(result.getValue().toString(), 2);
        };
    }

    private PuzzleSolution<Stream<String>, Long> partTwoSolution() {
        return input -> {
            final var lines = input.toList();
            final var result = IntStreamEx.range(0, lines.get(0).length()).boxed()
                .foldLeft(new Pair<>(lines, lines), (acc, index) -> new Pair<>(
                    acc.getKey().size() == 1 ? acc.getKey() : acc.getKey().stream()
                        .filter(line -> countOnes(acc.getKey(), index) >= 0 ? line.charAt(index) == '1' : line.charAt(index) == '0').toList(),
                    acc.getValue().size() == 1 ? acc.getValue() : acc.getValue().stream()
                        .filter(line -> countOnes(acc.getValue(), index) >= 0 ? line.charAt(index) == '0' : line.charAt(index) == '1').toList())
                );
            return Long.parseLong(result.getKey().get(0), 2) * Long.parseLong(result.getValue().get(0), 2);
        };
    }
}
