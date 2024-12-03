package xyz.ventosa.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day3Test {

    private static final Object SOLUTION_PART1_TEST = 161;
    private static final Object SOLUTION_PART1 = 188192787;
    private static final Object SOLUTION_PART2_TEST = 48;
    private static final Object SOLUTION_PART2 = 113965544;

    @Test
    void part1test() {
        var day = new Day3("test");
        assertEquals(SOLUTION_PART1_TEST, day.part1());
    }

    @Test
    void part1() {
        var day = new Day3("input");
        assertEquals(SOLUTION_PART1, day.part1());
    }

    @Test
    void part2test() {
        var day = new Day3("test2");
        assertEquals(SOLUTION_PART2_TEST, day.part2());
    }

    @Test
    void part2() {
        var day = new Day3("input");
        assertEquals(SOLUTION_PART2, day.part2());
    }

}