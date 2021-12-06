package com.omarassadi.adventofcode.day.day5;

import com.omarassadi.adventofcode.util.CollectionUtil;
import com.omarassadi.adventofcode.util.StreamExUtil;
import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import com.omarassadi.adventofcode.util.math.Vector2;
import lombok.experimental.ExtensionMethod;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Stream;

@Component
@ExtensionMethod({StreamExUtil.class, CollectionUtil.class})
public class PathInputParser implements InputParser<Stream<Path>> {

    @Override
    public Stream<Path> parse(final Stream<String> input) {
        return input.map(line -> {
            final var vectors = Arrays.stream(line.replaceAll(" -> ", ",")
                .split(",")).toList().ofSubLists(2).map(vec -> {
                final var startCoords = vec.stream().mapToLong(Long::parseLong).toArray();
                return new Vector2(startCoords[0], startCoords[1]);
            }).toList();
            return new Path(vectors.get(0), vectors.get(1));
        });
    }
}
