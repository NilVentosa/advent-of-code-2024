package xyz.ventosa;

import xyz.ventosa.day2.Day2;

public class Main {
    private static final String TEST = "test";
    private static final String INPUT = "input";

    public static void main(String[] args) {
        var day = new Day2(TEST);
        System.out.println(day.part1());
        System.out.println(day.part2());
    }
}
