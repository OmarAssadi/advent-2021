package com.omarassadi.adventofcode.util.io.input.resolver;

import java.util.stream.Stream;

public interface InputResolver {

    Stream<String> resolve(final int day);
}
