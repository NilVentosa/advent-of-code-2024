package xyz.ventosa.day10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day10Test {

    private static final Object SOLUTION_PART1_TEST = 36;
    private static final Object SOLUTION_PART1 = 566;
    private static final Object SOLUTION_PART2_TEST = 81;
    private static final Object SOLUTION_PART2 = null;

    @Test
    void part1test() {
        var day = new Day10("test");
        assertEquals(SOLUTION_PART1_TEST, day.part1());
    }

    @Test
    void part1() {
        var day = new Day10("input");
        assertEquals(SOLUTION_PART1, day.part1());
    }

    @Test
    void part2test() {
        var day = new Day10("test");
        assertEquals(SOLUTION_PART2_TEST, day.part2());
    }

    @Test
    void part2() {
        var day = new Day10("input");
        assertEquals(SOLUTION_PART2, day.part2());
    }

}