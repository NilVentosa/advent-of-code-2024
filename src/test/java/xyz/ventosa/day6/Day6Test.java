package xyz.ventosa.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day6Test {

    private static final Object SOLUTION_PART1_TEST = 41;
    private static final Object SOLUTION_PART1 = 4789;
    private static final Object SOLUTION_PART2_TEST = 6;
    private static final Object SOLUTION_PART2 = null;

    @Test
    void part1test() {
        var day = new Day6("test");
        assertEquals(SOLUTION_PART1_TEST, day.part1());
    }

    @Test
    void part1() {
        var day = new Day6("input");
        assertEquals(SOLUTION_PART1, day.part1());
    }

    @Test
    void part2test() {
        var day = new Day6("test");
        assertEquals(SOLUTION_PART2_TEST, day.part2());
    }

    @Test
    void part2() {
        var day = new Day6("input");
        assertEquals(SOLUTION_PART2, day.part2());
    }

}