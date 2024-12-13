package xyz.ventosa.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day12Test {

    private static final Object SOLUTION_PART1_TEST = 1930;
    private static final Object SOLUTION_PART1 = 1344578;
    private static final Object SOLUTION_PART2_TEST = 1206;
    private static final Object SOLUTION_PART2 = null;

    @Test
    void part1test() {
        var day = new Day12("test");
        assertEquals(SOLUTION_PART1_TEST, day.part1());
    }

    @Test
    void part1() {
        var day = new Day12("input");
        assertEquals(SOLUTION_PART1, day.part1());
    }

    @Test
    void part2test() {
        var day = new Day12("test");
        assertEquals(SOLUTION_PART2_TEST, day.part2());
    }

    @Test
    void part2() {
        var day = new Day12("input");
        assertEquals(SOLUTION_PART2, day.part2());
    }

}