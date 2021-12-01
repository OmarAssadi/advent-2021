package com.omarassadi.adventofcode.util.io.input.resolver;

import org.springframework.cache.annotation.Cacheable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileInputResolver implements InputResolver {

    private final Path basePath;

    public FileInputResolver(final Path basePath) {
        this.basePath = basePath;
    }

    @Override
    @Cacheable("puzzleInput")
    public List<String> resolve(final int day) {
        try {
            return Files.readAllLines(basePath.resolve("day-%d.txt".formatted(day)));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}
