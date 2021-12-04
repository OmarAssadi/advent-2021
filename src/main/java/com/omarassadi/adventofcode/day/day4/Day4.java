package com.omarassadi.adventofcode.day.day4;

import com.omarassadi.adventofcode.day.Day;
import com.omarassadi.adventofcode.day.PuzzleSolution;
import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Day4 extends Day<Bingo, Long> {

    public Day4(final InputParser<Bingo> inputParser) {
        super(4, inputParser);
    }

    @Override
    public List<PuzzleSolution<Bingo, Long>> getSolutions() {
        return List.of(partOneSolution(), partTwoSolution());
    }

    private PuzzleSolution<Bingo, Long> partOneSolution() {
        return bingo -> {
            var drawnNumbers = new LongOpenHashSet();
            for (long number : bingo.winningNumbers()) {
                drawnNumbers.add(number);
                for (var board : bingo.boards()) {
                    if (board.hasBingo(drawnNumbers)) {
                        return number * board.sumUnmarkedCells(drawnNumbers);
                    }
                }
            }
            return 0L;
        };
    }

    private PuzzleSolution<Bingo, Long> partTwoSolution() {
        return bingo -> {
            var drawnNumbers = new LongLinkedOpenHashSet();
            var winners = new ObjectOpenHashSet<BingoBoard>();
            for (long number : bingo.winningNumbers()) {
                drawnNumbers.add(number);
                for (var board : bingo.boards()) {
                    if (!winners.contains(board) && board.hasBingo(drawnNumbers)) {
                        if (winners.size() == bingo.boards().size() - 1) {
                            return number * board.sumUnmarkedCells(drawnNumbers);
                        }
                        winners.add(board);
                    }
                }
            }
            return 0L;
        };
    }
}
