package xyz.ventosa;

import xyz.ventosa.day1.Day1;

public class Main {
    private static final String TEST = "test";
    private static final String INPUT = "input";

    public static void main(String[] args) {
        var day = new Day1(TEST);
        System.out.println(day.part1());
        System.out.println(day.part2());
    }
}
