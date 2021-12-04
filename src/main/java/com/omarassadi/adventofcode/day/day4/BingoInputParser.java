package com.omarassadi.adventofcode.day.day4;

import com.omarassadi.adventofcode.util.CollectionUtil;
import com.omarassadi.adventofcode.util.StreamExUtil;
import com.omarassadi.adventofcode.util.StringUtil;
import com.omarassadi.adventofcode.util.io.input.parser.InputParser;
import it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import lombok.experimental.ExtensionMethod;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
@ExtensionMethod({StringUtil.class, CollectionUtil.class, StreamExUtil.class})
public class BingoInputParser implements InputParser<Bingo> {

    @Override
    public Bingo parse(final Stream<String> input) {
        final var lines = input.toList();
        final var winningNumbers = new LongLinkedOpenHashSet(lines.first().toLongs(","));
        final var size = lines.get(2).toLongs().length;
        final var boards = lines.drop(2).filterNot(String::isBlank)
            .ofSubLists(size).map(rows -> {
                final var grid = rows.stream().map(StringUtil::toLongs).toList();
                final var cells = new long[size * size];
                IntStream.range(0, size).forEach(row ->
                    System.arraycopy(grid.get(row), 0, cells, row * size, size));
                return new BingoBoard(cells);
            }).toArray(BingoBoard[]::new);
        return new Bingo(winningNumbers, ObjectSet.of(boards));
    }
}
