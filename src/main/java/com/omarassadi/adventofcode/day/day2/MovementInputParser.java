package com.omarassadi.adventofcode.day.day2;

import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import one.util.streamex.StreamEx;
import org.javatuples.Pair;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class MovementInputParser implements InputParser<List<Pair<String, Long>>> {

    @Override
    public List<Pair<String, Long>> parse(final Collection<String> input) {
        return StreamEx.of(input).map(line -> {
                final String[] command = line.split(" ");
                return new Pair<>(command[0], Long.parseLong(command[1]));
            }
        ).toList();
    }
}
