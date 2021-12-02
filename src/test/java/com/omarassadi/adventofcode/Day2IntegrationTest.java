package com.omarassadi.adventofcode;

import com.omarassadi.adventofcode.day.day2.Day2;
import com.omarassadi.adventofcode.util.io.input.resolver.InputResolver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ComponentScan
@SpringBootTest
public class Day2IntegrationTest {

    @Autowired
    private InputResolver resolver;

    @Autowired
    private Day2 day2;

    @Test
    void partOneSolution_should_return_2187380() {
        assertEquals(2187380, day2.getSolutions().get(0).solve(day2.parseInput(resolver.resolve(day2.getDay()))));
    }

    @Test
    void partTwoSolution_should_return_2086357770() {
        assertEquals(2086357770, day2.getSolutions().get(1).solve(day2.parseInput(resolver.resolve(day2.getDay()))));
    }

    @Test
    void solve_should_equal_2187380And2086357770() {
        assertEquals(List.of(2187380L, 2086357770L), day2.solve(resolver));
    }
}
