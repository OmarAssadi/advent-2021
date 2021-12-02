package com.omarassadi.adventofcode.day.day2;

import com.omarassadi.adventofcode.day.Day;
import com.omarassadi.adventofcode.day.PuzzleSolution;
import com.omarassadi.adventofcode.util.StreamExUtil;
import com.omarassadi.adventofcode.util.TupleUtil;
import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import lombok.experimental.ExtensionMethod;
import one.util.streamex.StreamEx;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ExtensionMethod({StreamEx.class, StreamExUtil.class, Pair.class, Triplet.class, TupleUtil.class})
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
        return input -> StreamEx.of(input).foldLeftAndThen(new Triplet<>(0L, 0L, 0L), (position, command) -> switch (command.getValue0()) {
            case "forward" -> position.plusAt0(command.getValue1()).applyIf(
                pos -> aiming,
                pos -> pos.plusAt1(pos.getValue2() * command.getValue1())
            );
            case "down" -> {
                if (aiming) {
                    yield position.plusAt2(command.getValue1());
                } else {
                    yield position.plusAt1(command.getValue1());
                }
            }
            case "up" -> {
                if (aiming) {
                    yield position.minusAt2(command.getValue1());
                } else {
                    yield position.minusAt1(command.getValue1());
                }
            }
            default -> position;
        }, acc -> acc.getValue0() * acc.getValue1());
    }
}
