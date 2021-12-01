package com.omarassadi.adventofcode.day;

@FunctionalInterface
public interface PuzzleSolution<T, R> {

    R solve(T input);
}
