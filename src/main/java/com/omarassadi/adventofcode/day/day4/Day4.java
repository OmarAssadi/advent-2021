package com.omarassadi.adventofcode.day.day4;

import com.omarassadi.adventofcode.day.Day;
import com.omarassadi.adventofcode.day.PuzzleSolution;
import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import one.util.streamex.LongStreamEx;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.BiPredicate;

@Component
public class Day4 extends Day<Bingo, Long> {

    public Day4(final InputParser<Bingo> inputParser) {
        super(4, inputParser);
    }

    @Override
    public List<PuzzleSolution<Bingo, Long>> getSolutions() {
        return List.of(partOneSolution(), partTwoSolution());
    }

    private PuzzleSolution<Bingo, Long> solution(final BiPredicate<LongSet, BingoBoard> takeBoard) {
        return bingo -> {
            final var drawnNumbers = new LongOpenHashSet();
            return LongStreamEx.of(bingo.winningNumbers().longStream()).flatMapToObj(num -> {
                drawnNumbers.add(num);
                return StreamEx.of(bingo.boards()).findFirst(board ->
                        takeBoard.test(drawnNumbers, board)).stream()
                    .map(board -> board.sumIncompleteCells(drawnNumbers) * num);
            }).findFirst().orElseThrow();
        };
    }

    private PuzzleSolution<Bingo, Long> partOneSolution() {
        return bingo -> solution((drawn, board) -> board.hasBingo(drawn)).solve(bingo);
    }

    private PuzzleSolution<Bingo, Long> partTwoSolution() {
        return bingo -> {
            final var winners = new ObjectOpenHashSet<BingoBoard>();
            return solution((drawn, board) -> board.hasBingo(drawn) && winners.add(board)
                && winners.size() == bingo.boards().size()).solve(bingo);
        };
    }
}
