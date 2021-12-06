package com.omarassadi.adventofcode.util;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

import static java.util.function.Predicate.not;

@UtilityClass
public final class StringUtil {

    public static long[] toLongs(final String numbers) {
        return toLongs(numbers, " ");
    }

    public static long[] toLongs(final String numbers, final String delimiter) {
        return Arrays.stream(numbers.split(delimiter)).filter(not(String::isBlank)).mapToLong(Long::parseLong).toArray();
    }
}
