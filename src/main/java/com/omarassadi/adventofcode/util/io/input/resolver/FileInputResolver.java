package com.omarassadi.adventofcode.util.io.input.resolver;

import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileInputResolver implements InputResolver {

    private final Path basePath;

    public FileInputResolver(final Path basePath) {
        this.basePath = basePath;
    }

    @Override
    @SneakyThrows(IOException.class)
    public Stream<String> resolve(final int day) {
        return Files.lines(basePath.resolve("day-%d.txt".formatted(day)));
    }
}
