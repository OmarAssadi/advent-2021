package com.omarassadi.adventofcode.day.day2;

import com.omarassadi.adventofcode.util.math.Vector2;
import com.omarassadi.adventofcode.util.math.Vector3;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public sealed abstract class Command permits Command.Forward, Command.Up, Command.Down {

    private final long units;

    Vector2 apply(final Vector2 position) {
        return switch (this) {
            case Forward ignored -> position.toBuilder().x(position.x() + units).build();
            case Down ignored -> position.toBuilder().y(position.y() + units).build();
            case Up ignored -> position.toBuilder().y(position.y() - units).build();
        };
    }

    Vector3 apply(final Vector3 position) {
        return switch (this) {
            case Forward ignored -> position.toBuilder().x(position.x() + units)
                .y(position.y() + position.z() * units).build();
            case Down ignored -> position.toBuilder().z(position.z() + units).build();
            case Up ignored -> position.toBuilder().z(position.z() - units).build();
        };
    }

    @Value
    @EqualsAndHashCode(callSuper = true)
    public static final class Forward extends Command {

        public Forward(final long units) {
            super(units);
        }
    }

    @Value
    @EqualsAndHashCode(callSuper = true)
    public static final class Up extends Command {

        public Up(final long units) {
            super(units);
        }
    }

    @Value
    @EqualsAndHashCode(callSuper = true)
    public static final class Down extends Command {

        public Down(final long units) {
            super(units);
        }
    }
}
