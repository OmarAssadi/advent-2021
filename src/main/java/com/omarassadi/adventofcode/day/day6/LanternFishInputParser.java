package com.omarassadi.adventofcode.day.day6;

import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Stream;

import static com.omarassadi.adventofcode.day.day6.Day6.STARTING_DAYS;
import static java.util.function.Predicate.not;

@Component
public class LanternFishInputParser implements InputParser<long[]> {

    @Override
    public long[] parse(final Stream<String> input) {
        return StreamEx.of(input).flatMap(line -> Arrays.stream(line.split(","))
                .filter(not(String::isBlank)).map(Integer::parseInt))
            .foldLeft(new long[STARTING_DAYS + 1], (freq, timer) -> {
                freq[timer]++;
                return freq;
            });
    }
}
