package com.omarassadi.adventofcode.util.math;

import lombok.Builder;
import lombok.With;

@With
public record Vector2(long x, long y) {

    public static Vector2 ZERO = new Vector2(0, 0);

    @Builder(toBuilder = true)
    public Vector2 {

    }

    public Vector2 plus(final Vector2 other) {
        return toBuilder().x(x + other.x).y(y + other.y).build();
    }

    public Vector2 minus(final Vector2 other) {
        return toBuilder().x(x - other.x).y(y - other.y).build();
    }

    public Vector2 times(final Vector2 other) {
        return toBuilder().x(x * other.x).y(y * other.y).build();
    }

    public Vector2 div(final Vector2 other) {
        return toBuilder().x(x / other.x).y(y / other.y).build();
    }
}
