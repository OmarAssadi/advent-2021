package com.omarassadi.adventofcode;

import com.omarassadi.adventofcode.day.day5.Day5;
import com.omarassadi.adventofcode.util.io.input.resolver.InputResolver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ComponentScan
@SpringBootTest
public class Day5IntegrationTest {

    @Autowired
    private InputResolver resolver;

    @Autowired
    private Day5 day5;

    @Test
    void partOneSolution_should_return_5576() {
        assertEquals(5576, day5.getSolutions().get(0).solve(day5.getInputParser().parse(resolver.resolve(day5.getDay()))));
    }

    @Test
    void partTwoSolution_should_return_18144() {
        assertEquals(18144, day5.getSolutions().get(1).solve(day5.getInputParser().parse(resolver.resolve(day5.getDay()))));
    }

    @Test
    void solve_should_equal_5576And23042() {
        assertEquals(List.of(5576L, 18144L), day5.solve(resolver));
    }
}
