package com.omarassadi.adventofcode;

import com.omarassadi.adventofcode.day.day3.Day3;
import com.omarassadi.adventofcode.util.io.input.resolver.InputResolver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ComponentScan
@SpringBootTest
public class Day3IntegrationTest {

    @Autowired
    private InputResolver resolver;

    @Autowired
    private Day3 day3;

    @Test
    void partOneSolution_should_return_3959450() {
        assertEquals(3959450, day3.getSolutions().get(0).solve(day3.getInputParser().parse(resolver.resolve(day3.getDay()))));
    }

    @Test
    void partTwoSolution_should_return_7440311() {
        assertEquals(7440311, day3.getSolutions().get(1).solve(day3.getInputParser().parse(resolver.resolve(day3.getDay()))));
    }

    @Test
    void solve_should_equal_3959450And7440311() {
        assertEquals(List.of(3959450L, 7440311L), day3.solve(resolver));
    }
}
