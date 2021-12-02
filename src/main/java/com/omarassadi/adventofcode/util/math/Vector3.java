package com.omarassadi.adventofcode.util.math;

import lombok.Builder;
import lombok.With;

@With
public record Vector3(long x, long y, long z) {

    public static final Vector3 ZERO = new Vector3(0, 0, 0);

    @Builder(toBuilder = true)
    public Vector3 {

    }

    public Vector3 plus(final Vector3 other) {
        return toBuilder().x(x + other.x).y(y + other.y).z(z + other.z).build();
    }

    public Vector3 minus(final Vector3 other) {
        return toBuilder().x(x - other.x).y(y - other.y).z(z - other.z).build();
    }

    public Vector3 times(final Vector3 other) {
        return toBuilder().x(x * other.x).y(y * other.y).z(z * other.z).build();
    }

    public Vector3 div(final Vector3 other) {
        return toBuilder().x(x / other.x).y(y / other.y).z(z / other.z).build();
    }
}
