package com.omarassadi.adventofcode.day.day2;

import com.omarassadi.adventofcode.day.Day;
import com.omarassadi.adventofcode.day.PuzzleSolution;
import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import com.omarassadi.adventofcode.util.math.Vector2;
import com.omarassadi.adventofcode.util.math.Vector3;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class Day2 extends Day<Stream<Command>, Long> {

    public Day2(final InputParser<Stream<Command>> inputParser) {
        super(2, inputParser);
    }

    @Override
    public List<PuzzleSolution<Stream<Command>, Long>> getSolutions() {
        return List.of(
            input -> solution(Vector2.ZERO).solve(input),
            input -> solution(Vector3.ZERO).solve(input)
        );
    }

    private PuzzleSolution<Stream<Command>, Long> solution(final Vector2 vector) {
        return commands -> {
            final var result = StreamEx.of(commands).foldLeft(vector, (position, command) -> command.apply(position));
            return result.x() * result.y();
        };
    }

    private PuzzleSolution<Stream<Command>, Long> solution(final Vector3 vector) {
        return commands -> {
            final var result = StreamEx.of(commands).foldLeft(vector, (position, command) -> command.apply(position));
            return result.x() * result.y();
        };
    }
}
