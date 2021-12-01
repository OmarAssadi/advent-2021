package com.omarassadi.adventofcode;

import com.omarassadi.adventofcode.day.Day;
import com.omarassadi.adventofcode.util.io.input.resolver.InputResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;

@Slf4j
@EnableCaching
@SpringBootApplication
public class AdventOfCodeApplication implements ApplicationRunner {

    private final InputResolver inputResolver;
    private final List<Day<?, ?>> days;

    public AdventOfCodeApplication(final InputResolver inputResolver, final List<Day<?, ?>> days) {
        this.inputResolver = inputResolver;
        this.days = days;
    }

    @Override
    public void run(final ApplicationArguments args) {
        days.forEach(day -> log.info("Day {}: {}", day.getDay(), day.solve(inputResolver)));
    }

    public static void main(final String[] args) {
        SpringApplication.run(AdventOfCodeApplication.class, args);
    }
}
