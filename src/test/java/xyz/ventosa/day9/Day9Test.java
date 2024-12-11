package xyz.ventosa.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class Day9Test {

    private static final Object SOLUTION_PART1_TEST = new BigInteger("1928");
    private static final Object SOLUTION_PART1 = new BigInteger("6353658451014");
    private static final Object SOLUTION_PART2_TEST = new BigInteger("2858");
    private static final Object SOLUTION_PART2 = new BigInteger("6382582136592");

    @Test
    void part1test() {
        var day = new Day9("test");
        assertEquals(SOLUTION_PART1_TEST, day.part1());
    }

    @Test
    void part1() {
        var day = new Day9("input");
        assertEquals(SOLUTION_PART1, day.part1());
    }

    @Test
    void part2test() {
        var day = new Day9("test");
        assertEquals(SOLUTION_PART2_TEST, day.part2());
    }

    @Test
    void part2() {
        var day = new Day9("input");
        assertEquals(SOLUTION_PART2, day.part2());
    }

}