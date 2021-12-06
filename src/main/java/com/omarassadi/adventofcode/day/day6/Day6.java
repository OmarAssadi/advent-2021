package com.omarassadi.adventofcode.day.day6;

import com.omarassadi.adventofcode.day.Day;
import com.omarassadi.adventofcode.day.PuzzleSolution;
import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import lombok.val;
import one.util.streamex.LongStreamEx;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class Day6 extends Day<long[], Long> {

    public static final int STARTING_DAYS = 8;
    private static final int PART_ONE_ITERATIONS = 80;
    private static final int PART_TWO_ITERATIONS = 256;
    private static final int RESET_DAYS = 6;

    public Day6(final InputParser<long[]> inputParser) {
        super(6, inputParser);
    }

    @Override
    public List<PuzzleSolution<long[], Long>> getSolutions() {
        return List.of(partOneSolution(), partTwoSolution());
    }

    private PuzzleSolution<long[], Long> partOneSolution() {
        return input -> solution(PART_ONE_ITERATIONS).solve(input);
    }

    private PuzzleSolution<long[], Long> partTwoSolution() {
        return input -> solution(PART_TWO_ITERATIONS).solve(input);
    }

    @SuppressWarnings("SuspiciousSystemArraycopy")
    private PuzzleSolution<long[], Long> solution(final int iterations) {
        return fish -> {
            IntStream.range(0, iterations).forEach(day -> {
                val newFish = fish[0];
                System.arraycopy(fish, 1, fish, 0, STARTING_DAYS);
                fish[STARTING_DAYS] = newFish;
                fish[RESET_DAYS] += newFish;
            });
            return LongStreamEx.of(fish).sum();
        };
    }
}
