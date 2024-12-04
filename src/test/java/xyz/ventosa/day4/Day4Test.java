package xyz.ventosa.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day4Test {

    private static final Object SOLUTION_PART1_TEST = 18;
    private static final Object SOLUTION_PART1 = 2390;
    private static final Object SOLUTION_PART2_TEST = 9;
    private static final Object SOLUTION_PART2 = 1809;

    @Test
    void part1test() {
        var day = new Day4("test");
        assertEquals(SOLUTION_PART1_TEST, day.part1());
    }

    @Test
    void part1() {
        var day = new Day4("input");
        assertEquals(SOLUTION_PART1, day.part1());
    }

    @Test
    void part2test() {
        var day = new Day4("test");
        assertEquals(SOLUTION_PART2_TEST, day.part2());
    }

    @Test
    void part2() {
        var day = new Day4("input");
        assertEquals(SOLUTION_PART2, day.part2());
    }

}