package com.omarassadi.adventofcode.util;

import one.util.streamex.StreamEx;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public final class StreamExUtil {

    private StreamExUtil() {

    }

    private static <T> StreamEx<List<T>> window(final StreamEx<List<T>> input, final int size) {
        return input.headTail((head, tail) -> head.size() == size ? window(
            tail.mapFirst(next -> StreamEx.of(head.subList(1, size), next).toFlatList(l -> l)), size).prepend(head)
            : window(tail.mapFirst(next -> StreamEx.of(head, next).toFlatList(l -> l)), size));
    }

    public static <T> Function<StreamEx<T>, StreamEx<List<T>>> windowed(final int size) {
        return s -> window(s.map(Collections::singletonList), size);
    }

    public static <T> StreamEx<List<T>> windowed(final StreamEx<T> stream, final int size) {
        return stream.chain(windowed(size));
    }
}
