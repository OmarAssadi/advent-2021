package com.omarassadi.adventofcode;

import com.omarassadi.adventofcode.day.day6.Day6;
import com.omarassadi.adventofcode.util.io.input.resolver.InputResolver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ComponentScan
@SpringBootTest
public class Day6IntegrationTest {

    @Autowired
    private InputResolver resolver;

    @Autowired
    private Day6 day6;

    @Test
    void partOneSolution_should_return_360268() {
        assertEquals(360268, day6.getSolutions().get(0).solve(day6.getInputParser().parse(resolver.resolve(day6.getDay()))));
    }

    @Test
    void partTwoSolution_should_return_1632146183902() {
        assertEquals(1632146183902L, day6.getSolutions().get(1).solve(day6.getInputParser().parse(resolver.resolve(day6.getDay()))));
    }

    @Test
    void solve_should_equal_360268And1632146183902() {
        assertEquals(List.of(360268L, 1632146183902L), day6.solve(resolver));
    }
}
