package xyz.ventosa.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day7Test {

    private static final Object SOLUTION_PART1_TEST = 3749L;
    private static final Object SOLUTION_PART1 = 5030892084481L;
    private static final Object SOLUTION_PART2_TEST = 11387L;
    private static final Object SOLUTION_PART2 = 91377448644679L;

    @Test
    void part1test() {
        var day = new Day7("test");
        assertEquals(SOLUTION_PART1_TEST, day.part1());
    }

    @Test
    void part1() {
        var day = new Day7("input");
        assertEquals(SOLUTION_PART1, day.part1());
    }

    @Test
    void part2test() {
        var day = new Day7("test");
        assertEquals(SOLUTION_PART2_TEST, day.part2());
    }

    @Test
    void part2() {
        var day = new Day7("input");
        assertEquals(SOLUTION_PART2, day.part2());
    }

}