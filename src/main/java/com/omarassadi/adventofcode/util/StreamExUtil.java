package com.omarassadi.adventofcode.util;

import lombok.experimental.ExtensionMethod;
import lombok.experimental.UtilityClass;
import one.util.streamex.StreamEx;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

@UtilityClass
@ExtensionMethod({CollectionUtil.class})
public final class StreamExUtil {

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

    public static <U, T, R> R foldLeftAndThen(final StreamEx<T> stream, U seed, BiFunction<U, ? super T, U> accumulator, Function<U, R> finisher) {
        final U value = stream.foldLeft(seed, accumulator);
        return finisher.apply(value);
    }

    public static <T> StreamEx<T> filterNot(final StreamEx<T> stream, Predicate<? super T> predicate) {
        return stream.filter(element -> !predicate.test(element));
    }

    public static <T> StreamEx<List<T>> ofSubLists(final StreamEx<T> source, final int length) {
        return source.toList().ofSubLists(length);
    }
}
