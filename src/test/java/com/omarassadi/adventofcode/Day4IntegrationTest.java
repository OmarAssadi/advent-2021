package com.omarassadi.adventofcode;

import com.omarassadi.adventofcode.day.day4.Day4;
import com.omarassadi.adventofcode.util.io.input.resolver.InputResolver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ComponentScan
@SpringBootTest
public class Day4IntegrationTest {

    @Autowired
    private InputResolver resolver;

    @Autowired
    private Day4 day4;

    @Test
    void partOneSolution_should_return_31424() {
        assertEquals(31424, day4.getSolutions().get(0).solve(day4.getInputParser().parse(resolver.resolve(day4.getDay()))));
    }

    @Test
    void partTwoSolution_should_return_23042() {
        assertEquals(23042, day4.getSolutions().get(1).solve(day4.getInputParser().parse(resolver.resolve(day4.getDay()))));
    }

    @Test
    void solve_should_equal_31424And23042() {
        assertEquals(List.of(31424L, 23042L), day4.solve(resolver));
    }
}
