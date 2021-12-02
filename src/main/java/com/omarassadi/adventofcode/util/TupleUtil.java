package com.omarassadi.adventofcode.util;

import lombok.experimental.UtilityClass;
import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.util.function.Function;
import java.util.function.Predicate;

@UtilityClass
public class TupleUtil {

    public static <A, B> Pair<A, B> applyIf(final Pair<A, B> pair, final Predicate<Pair<A, B>> predicate,
                                                  final Function<Pair<A, B>, Pair<A, B>> finisher) {
        return predicate.test(pair) ? finisher.apply(pair) : pair;
    }

    public static <B> Pair<Integer, B> plusAt0(final Pair<Integer, B> pair, final int value) {
        return pair.setAt0(pair.getValue0() + value);
    }

    public static <A> Pair<A, Integer> plusAt1(final Pair<A, Integer> pair, final int value) {
        return pair.setAt1(pair.getValue1() + value);
    }

    public static <B> Pair<Integer, B> minusAt0(final Pair<Integer, B> pair, final int value) {
        return pair.setAt0(pair.getValue0() - value);
    }

    public static <A> Pair<A, Integer> minusAt1(final Pair<A, Integer> pair, final int value) {
        return pair.setAt1(pair.getValue1() - value);
    }

    public static <B> Pair<Long, B> plusAt0(final Pair<Long, B> pair, final long value) {
        return pair.setAt0(pair.getValue0() + value);
    }

    public static <A> Pair<A, Long> plusAt1(final Pair<A, Long> pair, final long value) {
        return pair.setAt1(pair.getValue1() + value);
    }

    public static <B> Pair<Long, B> minusAt0(final Pair<Long, B> pair, final long value) {
        return pair.setAt0(pair.getValue0() - value);
    }

    public static <A> Pair<A, Long> minusAt1(final Pair<A, Long> pair, final long value) {
        return pair.setAt1(pair.getValue1() - value);
    }

    public static <B> Pair<Double, B> plusAt0(final Pair<Double, B> pair, final double value) {
        return pair.setAt0(pair.getValue0() + value);
    }

    public static <A> Pair<A, Double> plusAt1(final Pair<A, Double> pair, final double value) {
        return pair.setAt1(pair.getValue1() + value);
    }

    public static <B> Pair<Double, B> minusAt0(final Pair<Double, B> pair, final double value) {
        return pair.setAt0(pair.getValue0() - value);
    }

    public static <A> Pair<A, Double> minusAt1(final Pair<A, Double> pair, final double value) {
        return pair.setAt1(pair.getValue1() - value);
    }

    public static <A, B, C> Triplet<A, B, C> applyIf(final Triplet<A, B, C> triplet, final Predicate<Triplet<A, B, C>> predicate,
                                                        final Function<Triplet<A, B, C>, Triplet<A, B, C>> finisher) {
        return predicate.test(triplet) ? finisher.apply(triplet) : triplet;
    }

    public static <B, C> Triplet<Integer, B, C> plusAt0(final Triplet<Integer, B, C> triplet, final int value) {
        return triplet.setAt0(triplet.getValue0() + value);
    }

    public static <A, C> Triplet<A, Integer, C> plusAt1(final Triplet<A, Integer, C> triplet, final int value) {
        return triplet.setAt1(triplet.getValue1() + value);
    }

    public static <A, B> Triplet<A, B, Integer> plusAt2(final Triplet<A, B, Integer> triplet, final int value) {
        return triplet.setAt2(triplet.getValue2() + value);
    }

    public static <B, C> Triplet<Integer, B, C> minusAt0(final Triplet<Integer, B, C> triplet, final int value) {
        return triplet.setAt0(triplet.getValue0() - value);
    }

    public static <A, C> Triplet<A, Integer, C> minusAt1(final Triplet<A, Integer, C> triplet, final int value) {
        return triplet.setAt1(triplet.getValue1() - value);
    }

    public static <A, B> Triplet<A, B, Integer> minusAt2(final Triplet<A, B, Integer> triplet, final int value) {
        return triplet.setAt2(triplet.getValue2() - value);
    }

    public static <B, C> Triplet<Long, B, C> plusAt0(final Triplet<Long, B, C> triplet, final long value) {
        return triplet.setAt0(triplet.getValue0() + value);
    }

    public static <A, C> Triplet<A, Long, C> plusAt1(final Triplet<A, Long, C> triplet, final long value) {
        return triplet.setAt1(triplet.getValue1() + value);
    }

    public static <A, B> Triplet<A, B, Long> plusAt2(final Triplet<A, B, Long> triplet, final long value) {
        return triplet.setAt2(triplet.getValue2() + value);
    }

    public static <B, C> Triplet<Long, B, C> minusAt0(final Triplet<Long, B, C> triplet, final long value) {
        return triplet.setAt0(triplet.getValue0() - value);
    }

    public static <A, C> Triplet<A, Long, C> minusAt1(final Triplet<A, Long, C> triplet, final long value) {
        return triplet.setAt1(triplet.getValue1() - value);
    }

    public static <A, B> Triplet<A, B, Long> minusAt2(final Triplet<A, B, Long> triplet, final long value) {
        return triplet.setAt2(triplet.getValue2() - value);
    }

    public static <B, C> Triplet<Double, B, C> plusAt0(final Triplet<Double, B, C> triplet, final double value) {
        return triplet.setAt0(triplet.getValue0() + value);
    }

    public static <A, C> Triplet<A, Double, C> plusAt1(final Triplet<A, Double, C> triplet, final double value) {
        return triplet.setAt1(triplet.getValue1() + value);
    }

    public static <A, B> Triplet<A, B, Double> plusAt2(final Triplet<A, B, Double> triplet, final double value) {
        return triplet.setAt2(triplet.getValue2() + value);
    }

    public static <B, C> Triplet<Double, B, C> minusAt0(final Triplet<Double, B, C> triplet, final double value) {
        return triplet.setAt0(triplet.getValue0() - value);
    }

    public static <A, C> Triplet<A, Double, C> minusAt1(final Triplet<A, Double, C> triplet, final double value) {
        return triplet.setAt1(triplet.getValue1() - value);
    }

    public static <A, B> Triplet<A, B, Double> minusAt2(final Triplet<A, B, Double> triplet, final double value) {
        return triplet.setAt2(triplet.getValue2() - value);
    }
}
