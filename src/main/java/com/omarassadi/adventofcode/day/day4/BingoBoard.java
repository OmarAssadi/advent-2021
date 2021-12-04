package com.omarassadi.adventofcode.day.day4;

import com.google.common.base.Preconditions;
import it.unimi.dsi.fastutil.longs.LongSet;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import one.util.streamex.IntStreamEx;

import java.util.Arrays;
import java.util.stream.IntStream;

@ToString
@EqualsAndHashCode
public final class BingoBoard {

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
        if (IntStream.range(0, size).anyMatch(c -> isColumnCompleted(drawnNumbers, c))) {
            return true;
        }
        return IntStream.range(0, size).anyMatch(r -> isRowCompleted(drawnNumbers, r));
    }

    public boolean isColumnCompleted(final LongSet drawnNumbers, final int column) {
        return IntStreamEx.range(column, cells.length, size)
            .mapToObj(cell -> drawnNumbers.contains(cells[cell]))
            .allMatch(cellComplete -> cellComplete);
    }

    public boolean isRowCompleted(final LongSet drawnNumbers, final int row) {
        return IntStream.range(size * row, size * row + size)
            .mapToObj(cell -> drawnNumbers.contains(cells[cell]))
            .allMatch(cellComplete -> cellComplete);
    }

    public long sumIncompleteCells(final LongSet drawnNumbers) {
        return Arrays.stream(cells).filter(cell -> !drawnNumbers.contains(cell)).sum();
    }
}
