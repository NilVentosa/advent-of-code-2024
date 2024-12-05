package xyz.ventosa.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day5Test {

    private static final Object SOLUTION_PART1_TEST = 143;
    private static final Object SOLUTION_PART1 = 4905;
    private static final Object SOLUTION_PART2_TEST = 123;
    private static final Object SOLUTION_PART2 = 6204;

    @Test
    void part1test() {
        var day = new Day5("test");
        assertEquals(SOLUTION_PART1_TEST, day.part1());
    }

    @Test
    void part1() {
        var day = new Day5("input");
        assertEquals(SOLUTION_PART1, day.part1());
    }

    @Test
    void part2test() {
        var day = new Day5("test");
        assertEquals(SOLUTION_PART2_TEST, day.part2());
    }

    @Test
    void part2() {
        var day = new Day5("input");
        assertEquals(SOLUTION_PART2, day.part2());
    }

}