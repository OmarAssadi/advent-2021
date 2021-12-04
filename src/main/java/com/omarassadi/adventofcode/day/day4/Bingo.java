package com.omarassadi.adventofcode.day.day4;

import it.unimi.dsi.fastutil.longs.LongSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;

public record Bingo(LongSet winningNumbers, ObjectSet<BingoBoard> boards) {

}
