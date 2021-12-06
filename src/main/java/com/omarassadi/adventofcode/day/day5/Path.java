package com.omarassadi.adventofcode.day.day5;

import com.omarassadi.adventofcode.util.math.Vector2;
import lombok.With;
import lombok.val;
import one.util.streamex.StreamEx;

import java.util.Collection;

@With
public record Path(Vector2 start, Vector2 end) {

    public Collection<Vector2> getSteps() {
        val sign = new Vector2((long) Math.signum(end.x() - start.x()),
            (long) Math.signum(end.y() - start.y()));
        return StreamEx.iterate(start, step -> step.plus(sign))
            .takeWhile(step -> step.x() != end.x() || step.y() != end.y())
            .append(end).toList();
    }
}
