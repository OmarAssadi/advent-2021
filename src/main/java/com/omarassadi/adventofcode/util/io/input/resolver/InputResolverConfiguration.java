package com.omarassadi.adventofcode.util.io.input.resolver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Paths;

@Configuration
public class InputResolverConfiguration {

    @Bean
    public FileInputResolver fileInputResolver(@Value("${puzzle.input-data-path}") final String inputDataPath) {
        return new FileInputResolver(Paths.get(inputDataPath));
    }
}
