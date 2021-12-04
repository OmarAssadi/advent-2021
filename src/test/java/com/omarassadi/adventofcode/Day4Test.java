package com.omarassadi.adventofcode;

import com.omarassadi.adventofcode.day.day4.Bingo;
import com.omarassadi.adventofcode.day.day4.BingoBoard;
import com.omarassadi.adventofcode.day.day4.BingoInputParser;
import com.omarassadi.adventofcode.day.day4.Day4;
import com.omarassadi.adventofcode.util.io.input.resolver.InputResolver;
import it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4Test {

    private final List<String> exampleInput = List.of(
        "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1",
        "",
        "22 13 17 11  0",
        " 8  2 23  4 24",
        "21  9 14 16  7",
        " 6 10  3 18  5",
        " 1 12 20 15 19",
        "",
        " 3 15  0  2 22",
        " 9 18 13 17  5",
        "19  8  7 25 23",
        "20 11 10 24  4",
        "14 21 16 12  6",
        "",
        "14 21 17 24  4",
        "10 16 15  9 19",
        "18  8 23 26 20",
        "22 11 13  6  5",
        " 2  0 12  3  7"
    );

    private final Bingo exampleParsedInput = new Bingo(new LongLinkedOpenHashSet(new long[]{
        7L, 4L, 9L, 5L, 11L, 17L, 23L, 2L, 0L, 14L, 21L, 24L, 10L, 16L, 13L, 6L, 15L,
        25L, 12L, 22L, 18L, 20L, 8L, 19L, 3L, 26L, 1L}),
        new ObjectLinkedOpenHashSet<>(new BingoBoard[]{
            new BingoBoard(new long[]{22, 13, 17, 11, 0, 8, 2, 23, 4, 24, 21, 9, 14, 16, 7,
                6, 10, 3, 18, 5, 1, 12, 20, 15, 19}),
            new BingoBoard(new long[]{3, 15, 0, 2, 22, 9, 18, 13, 17, 5, 19, 8, 7, 25, 23,
                20, 11, 10, 24, 4, 14, 21, 16, 12, 6}),
            new BingoBoard(new long[]{14, 21, 17, 24, 4, 10, 16, 15, 9, 19, 18, 8, 23, 26,
                20, 22, 11, 13, 6, 5, 2, 0, 12, 3, 7})
        }));

    private final InputResolver dummyInputResolver = day -> exampleInput.stream();

    @Test
    void partOneSolution_should_return_4512() {
        final Day4 day4 = new Day4(new BingoInputParser());
        assertEquals(4512, day4.getSolutions().get(0).solve(new BingoInputParser().parse(exampleInput.stream())));
    }

    @Test
    void partTwoSolution_should_return_1924() {
        final Day4 day4 = new Day4(new BingoInputParser());
        assertEquals(1924, day4.getSolutions().get(1).solve(new BingoInputParser().parse(exampleInput.stream())));
    }

    @Test
    void solve_should_equal_4512And1924() {
        final Day4 day4 = new Day4(new BingoInputParser());
        assertEquals(List.of(4512L, 1924L), day4.solve(dummyInputResolver));
    }

    @Test
    void parse_should_return_exampleInput() {
        final Day4 day4 = new Day4(new BingoInputParser());
        assertEquals(exampleParsedInput, day4.getInputParser().parse(exampleInput.stream()));
    }
}
