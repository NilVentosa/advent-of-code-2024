package xyz.ventosa.day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day2Test {

    private static final Object SOLUTION_PART1_TEST = 2;
    private static final Object SOLUTION_PART2_TEST = 4;
    private static final Object SOLUTION_PART1 = 252;
    private static final Object SOLUTION_PART2 = 324;

    @Test
    void part1test() {
        var day = new Day2("test");
        assertEquals(SOLUTION_PART1_TEST, day.part1());
    }

    @Test
    void part2test() {
        var day = new Day2("test");
        assertEquals(SOLUTION_PART2_TEST, day.part2());
    }

    @Test
    void part1() {
        var day = new Day2("input");
        assertEquals(SOLUTION_PART1, day.part1());
    }

    @Test
    void part2() {
        var day = new Day2("input");
        assertEquals(SOLUTION_PART2, day.part2());
    }

}