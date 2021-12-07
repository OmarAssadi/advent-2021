package com.omarassadi.adventofcode;

import com.omarassadi.adventofcode.day.day7.Day7;
import com.omarassadi.adventofcode.util.io.input.resolver.InputResolver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ComponentScan
@SpringBootTest
public class Day7IntegrationTest {

    @Autowired
    private InputResolver resolver;

    @Autowired
    private Day7 day7;

    @Test
    void partOneSolution_should_return_355150() {
        assertEquals(355150, day7.getSolutions().get(0).solve(day7.getInputParser().parse(resolver.resolve(day7.getDay()))));
    }

    @Test
    void partTwoSolution_should_return_98368490() {
        assertEquals(98368490, day7.getSolutions().get(1).solve(day7.getInputParser().parse(resolver.resolve(day7.getDay()))));
    }

    @Test
    void solve_should_equal_355150And98368490() {
        assertEquals(List.of(355150L, 98368490L), day7.solve(resolver));
    }
}
