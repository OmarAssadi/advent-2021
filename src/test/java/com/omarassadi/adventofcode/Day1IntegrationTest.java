package com.omarassadi.adventofcode;

import com.omarassadi.adventofcode.day.day1.Day1;
import com.omarassadi.adventofcode.util.io.input.resolver.InputResolver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ComponentScan
@SpringBootTest
public class Day1IntegrationTest {

    @Autowired
    private InputResolver resolver;

    @Autowired
    private Day1 day1;

    @Test
    void partOneSolution_should_return_1681() {
        assertEquals(1681, day1.partOneSolution().solve(day1.parseInput(resolver.resolve(day1.getDay()))));
    }

    @Test
    void partTwoSolution_should_return_1704() {
        assertEquals(1704, day1.partTwoSolution().solve(day1.parseInput(resolver.resolve(day1.getDay()))));
    }

    @Test
    void solve_should_equal_1681And1704() {
        assertEquals(List.of(1681L, 1704L), day1.solve(resolver));
    }
}
