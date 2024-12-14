package xyz.ventosa.day14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day14Test {

    private static final Object SOLUTION_PART1_TEST = 12;
    private static final Object SOLUTION_PART1 = 225521010;
    private static final Object SOLUTION_PART2 = 7774;

    @Test
    void part1test() {
        var day = new Day14("test");
        assertEquals(SOLUTION_PART1_TEST, day.part1());
    }

    @Test
    void part1() {
        var day = new Day14("input");
        assertEquals(SOLUTION_PART1, day.part1());
    }

    @Test
    void part2() {
        var day = new Day14("input");
        assertEquals(SOLUTION_PART2, day.part2());
    }

}