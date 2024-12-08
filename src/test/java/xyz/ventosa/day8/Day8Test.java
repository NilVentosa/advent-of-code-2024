package xyz.ventosa.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day8Test {

    private static final Object SOLUTION_PART1_TEST = 14;
    private static final Object SOLUTION_PART1 = 341;
    private static final Object SOLUTION_PART2_TEST = 34;
    private static final Object SOLUTION_PART2 = 1134;

    @Test
    void part1test() {
        var day = new Day8("test");
        assertEquals(SOLUTION_PART1_TEST, day.part1());
    }

    @Test
    void part1() {
        var day = new Day8("input");
        assertEquals(SOLUTION_PART1, day.part1());
    }

    @Test
    void part2test() {
        var day = new Day8("test");
        assertEquals(SOLUTION_PART2_TEST, day.part2());
    }

    @Test
    void part2() {
        var day = new Day8("input");
        assertEquals(SOLUTION_PART2, day.part2());
    }

}