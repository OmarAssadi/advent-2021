package com.omarassadi.adventofcode.util.io.input.parser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InputParserConfiguration {

    @Bean
    public InputParser<List<Integer>> integerListInputParser() {
        return new MappingInputParser<>(Integer::parseInt);
    }

    @Bean
    public InputParser<List<Long>> longListInputParser() {
        return new MappingInputParser<>(Long::parseLong);
    }

    @Bean
    public InputParser<List<Double>> doubleListInputParser() {
        return new MappingInputParser<>(Double::parseDouble);
    }
}
