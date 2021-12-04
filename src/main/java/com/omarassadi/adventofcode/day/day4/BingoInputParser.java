package com.omarassadi.adventofcode.day.day4;

import com.omarassadi.adventofcode.util.StreamExUtil;
import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import lombok.experimental.ExtensionMethod;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Stream;

@Component
@ExtensionMethod({StreamExUtil.class})
public class BingoInputParser implements InputParser<Bingo> {

    @Override
    public Bingo parse(final Stream<String> input) {
        final var lines = input.toList();
        final var winningNumbers = new LongLinkedOpenHashSet(stringToLongs(lines.get(0), ","));
        final var boardSize = stringToCells(lines.get(2)).length;
        final var boards = ObjectSet.of(StreamEx.ofSubLists(lines.stream().skip(2).filter(s -> !s.isBlank()).toList(), boardSize)
            .map(rows -> {
                final var grid = rows.stream().map(this::stringToCells).toList();
                final var board = new long[boardSize * boardSize];
                for (var y = 0; y < boardSize; y++) {
                    var row = grid.get(y);
                    System.arraycopy(row, 0, board, y * boardSize, boardSize);
                }
                return new BingoBoard(board);
            }).toArray(BingoBoard[]::new));
        return new Bingo(winningNumbers, boards);
    }

    private long[] stringToLongs(final String row, final String delimiter) {
        return Arrays.stream(row.split(delimiter)).filter(s -> !s.isBlank()).mapToLong(Long::parseLong).toArray();
    }

    private long[] stringToCells(final String row) {
        return stringToLongs(row, " ");
    }
}
