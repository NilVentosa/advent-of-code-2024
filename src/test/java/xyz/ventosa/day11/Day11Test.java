package xyz.ventosa.day11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class Day11Test {

    private static final Object SOLUTION_PART1_TEST = new BigInteger("55312");
    private static final Object SOLUTION_PART1 = new BigInteger("193899");
    private static final Object SOLUTION_PART2_TEST = new BigInteger("65601038650482");
    private static final Object SOLUTION_PART2 = new BigInteger("229682160383225");

    @Test
    void part1test() {
        var day = new Day11("test");
        assertEquals(SOLUTION_PART1_TEST, day.part1());
    }

    @Test
    void part1() {
        var day = new Day11("input");
        assertEquals(SOLUTION_PART1, day.part1());
    }

    @Test
    void part2test() {
        var day = new Day11("test");
        assertEquals(SOLUTION_PART2_TEST, day.part2());
    }

    @Test
    void part2() {
        var day = new Day11("input");
        assertEquals(SOLUTION_PART2, day.part2());
    }

}