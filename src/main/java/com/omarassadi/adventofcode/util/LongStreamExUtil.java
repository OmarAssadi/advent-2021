package com.omarassadi.adventofcode.util;

import one.util.streamex.LongStreamEx;

import java.util.List;

public class LongStreamExUtil {

    private LongStreamExUtil() {

    }

    public static long sum(final List<Long> stream) {
        return LongStreamEx.of(stream).sum();
    }
}
