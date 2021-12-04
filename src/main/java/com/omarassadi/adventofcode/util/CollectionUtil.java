package com.omarassadi.adventofcode.util;

import lombok.experimental.UtilityClass;
import one.util.streamex.StreamEx;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

@UtilityClass
public final class CollectionUtil {

    public static <T, C extends Collection<T>> T first(final C input) {
        return input.stream().findFirst().orElse(null);
    }

    public static <T, C extends Collection<T>> StreamEx<T> drop(final C input, final int amount) {
        return StreamEx.of(input).skip(amount);
    }

    public static <T, C extends Collection<T>> StreamEx<T> filterNot(final C collection, Predicate<? super T> predicate) {
        return StreamEx.of(collection).filter(element -> !predicate.test(element));
    }

    public static <T> StreamEx<List<T>> ofSubLists(final List<T> source, final int length) {
        return StreamEx.ofSubLists(source, length);
    }
}
