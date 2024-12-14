package xyz.ventosa.day13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day13Test {

    private static final Object SOLUTION_PART1_TEST = 480;
    private static final Object SOLUTION_PART1 = null;
    private static final Object SOLUTION_PART2_TEST = null;
    private static final Object SOLUTION_PART2 = null;

    @Test
    void part1test() {
        var day = new Day13("test");
        assertEquals(SOLUTION_PART1_TEST, day.part1());
    }

    @Test
    void part1() {
        var day = new Day13("input");
        assertEquals(SOLUTION_PART1, day.part1());
    }

    @Test
    void part2test() {
        var day = new Day13("test");
        assertEquals(SOLUTION_PART2_TEST, day.part2());
    }

    @Test
    void part2() {
        var day = new Day13("input");
        assertEquals(SOLUTION_PART2, day.part2());
    }

}