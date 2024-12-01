package xyz.ventosa;

import java.util.ArrayList;
import java.util.HashMap;

public class Day1 {
    public static void main(String[] args) {
        var day1 = new Day1();
        day1.part2();
    }

    void part1() {
        var input = Utils.getInput("Day1/input");
        var listOne = new ArrayList<Integer>();
        var listTwo = new ArrayList<Integer>();
        for (String s: input) {
            var splitted = s.split("   ");
            listOne.add(Integer.parseInt(splitted[0]));
            listTwo.add(Integer.parseInt(splitted[1]));
        }
        var sortedListOne = listOne.stream().sorted().toList();
        var sortedListTwo = listTwo.stream().sorted().toList();
        var result = 0;
        for (int i = 0; i < sortedListOne.size(); i++) {
            result += Math.abs(sortedListOne.get(i) - sortedListTwo.get(i));
        }
        System.out.println(result);
    }

    void part2() {
        var input = Utils.getInput("Day1/input");
        var listOne = new ArrayList<Integer>();
        var listTwo = new ArrayList<Integer>();
        for (String s: input) {
            var splitted = s.split("   ");
            listOne.add(Integer.parseInt(splitted[0]));
            listTwo.add(Integer.parseInt(splitted[1]));
        }
        var mapTwo = new HashMap<Integer, Integer>();
        for (int i: listTwo) {
            if (mapTwo.containsKey(i)) {
                mapTwo.put(i, mapTwo.get(i) + 1);
            } else {
                mapTwo.put(i, 1);
            }
        }
        int result = 0;
        for (int i: listOne) {
            if (mapTwo.containsKey(i)) {
                result += i * mapTwo.get(i);
            }
        }
        System.out.println(result);
    }
}