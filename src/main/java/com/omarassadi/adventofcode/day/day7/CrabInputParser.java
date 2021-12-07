package com.omarassadi.adventofcode.day.day7;

import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.omarassadi.adventofcode.day.day6.Day6.STARTING_DAYS;
import static java.util.function.Predicate.not;
@Component
public class CrabInputParser implements InputParser<List<Long>> {
    @Override
    public List<Long> parse(final Stream<String> input) {
        return StreamEx.of(input).flatMap(line -> Arrays.stream(line.split(","))
                .filter(not(String::isBlank)).map(Long::parseLong)).toList();/*foldLeft(new HashMap<Long, Long>(), (acc, value) -> {
                    acc.merge(value, 1L, Long::sum);
                    return acc;
        });*/
        /*return StreamEx.of(input).flatMap(line -> Arrays.stream(line.split(","))
                .filter(not(String::isBlank)).map(Integer::parseInt))
            .foldLeft(new long[STARTING_DAYS + 1], (freq, timer) -> {
                freq[timer]++;
                return freq;
            });*/
    }
}
