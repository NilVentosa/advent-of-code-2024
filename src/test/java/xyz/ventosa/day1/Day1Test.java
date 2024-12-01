package xyz.ventosa.day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day1Test {

    private static final Integer SOLUTION_PART1_TEST = 11;
    private static final Integer SOLUTION_PART2_TEST = 31;
    private static final Integer SOLUTION_PART1 = 1320851;
    private static final Integer SOLUTION_PART2 = 26859182;

    @Test
    void part1test() {
        var day = new Day1("test");
        assertEquals(SOLUTION_PART1_TEST, day.part1());
    }

    @Test
    void part2test() {
        var day = new Day1("test");
        assertEquals(SOLUTION_PART2_TEST, day.part2());
    }

    @Test
    void part1() {
        var day = new Day1("input");
        assertEquals(SOLUTION_PART1, day.part1());
    }

    @Test
    void part2() {
        var day = new Day1("input");
        assertEquals(SOLUTION_PART2, day.part2());
    }
  
}