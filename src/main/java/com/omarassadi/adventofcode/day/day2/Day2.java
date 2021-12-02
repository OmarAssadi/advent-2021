package com.omarassadi.adventofcode.day.day2;

import com.omarassadi.adventofcode.day.Day;
import com.omarassadi.adventofcode.day.PuzzleSolution;
import com.omarassadi.adventofcode.util.StreamExUtil;
import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import lombok.experimental.ExtensionMethod;
import one.util.streamex.StreamEx;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ExtensionMethod({StreamEx.class, StreamExUtil.class})
public class Day2 extends Day<List<Pair<String, Long>>, Long> {

    public Day2(final InputParser<List<Pair<String, Long>>> inputParser) {
        super(2, inputParser);
    }

    @Override
    public List<PuzzleSolution<List<Pair<String, Long>>, Long>> getSolutions() {
        return List.of(
            solution(false),
            solution(true)
        );
    }

    private PuzzleSolution<List<Pair<String, Long>>, Long> solution(final boolean aiming) {
        return input -> StreamEx.of(input).foldLeftAndThen(new Triplet<>(0L, 0L, 0L), (position, command) -> {
            long horizontal = position.getValue0();
            long depth = position.getValue1();
            long aim = position.getValue2();
            switch (command.getValue0()) {
                case "forward" -> {
                    horizontal += command.getValue1();
                    if (aiming) {
                        depth += aim * command.getValue1();
                    }
                }
                case "down" -> {
                    if (aiming) {
                        aim += command.getValue1();
                    } else {
                        depth += command.getValue1();
                    }
                }
                case "up" -> {
                    if (aiming) {
                        aim -= command.getValue1();
                    } else {
                        depth -= command.getValue1();
                    }
                }
                default -> new Pair<>(position.getValue0(), position.getValue1());
            }
            return new Triplet<>(horizontal, depth, aim);
        }, acc -> acc.getValue0() * acc.getValue1());
    }
}
