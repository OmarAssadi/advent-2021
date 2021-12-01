package com.omarassadi.adventofcode.util;

import one.util.streamex.IntStreamEx;

import java.util.List;

public class IntStreamExUtil {

    private IntStreamExUtil() {

    }

    public static int sum(final List<Integer> stream) {
        return IntStreamEx.of(stream).sum();
    }
}
