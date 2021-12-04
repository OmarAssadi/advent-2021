package com.omarassadi.adventofcode.day.day4;

import com.google.common.base.Preconditions;
import it.unimi.dsi.fastutil.longs.LongSet;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@ToString
@EqualsAndHashCode
public class BingoBoard {

    private final long[] cells;
    @Getter
    private final int size;

    public BingoBoard(final long[] cells) {
        final var cellCount = Math.sqrt(cells.length);
        Preconditions.checkArgument(cellCount % 1 == 0, "%s must be of an equal size!", cells);
        this.size = (int) cellCount;
        this.cells = cells;
    }

    public boolean hasBingo(final LongSet drawnNumbers) {
        for (var column = 0; column < size; column++) {
            if (columnSolved(drawnNumbers, column)) {
                return true;
            }
        }

        for (var row = 0; row < size; row++) {
            if (rowSolved(drawnNumbers, row)) {
                return true;
            }
        }
        return false;
    }

    public boolean columnSolved(final LongSet drawnNumbers, final int column) {
        var solved = 0;
        for (var cell = column; cell < cells.length; cell += size) {
            if (drawnNumbers.contains(cells[cell])) {
                solved++;
            }
        }
        return solved == size;
    }

    public boolean rowSolved(final LongSet drawnNumbers, final int row) {
        final var start = size * row;
        final var end = start + size;
        var solved = 0;
        for (var cell = start; cell < end; cell++) {
            if (drawnNumbers.contains(cells[cell])) {
                solved++;
            }
        }
        return solved == size;
    }

    public long sumUnmarkedCells(final LongSet drawnNumbers) {
        return Arrays.stream(cells).filter(cell -> !drawnNumbers.contains(cell)).sum();
    }
}
