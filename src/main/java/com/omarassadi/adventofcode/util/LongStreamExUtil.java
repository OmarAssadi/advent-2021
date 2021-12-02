package com.omarassadi.adventofcode.util;

import lombok.experimental.UtilityClass;
import one.util.streamex.LongStreamEx;

import java.util.List;

@UtilityClass
public class LongStreamExUtil {

    public static long sum(final List<Long> stream) {
        return LongStreamEx.of(stream).sum();
    }
}
