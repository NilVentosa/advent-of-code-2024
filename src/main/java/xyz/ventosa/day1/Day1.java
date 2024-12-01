package xyz.ventosa.day1;

import xyz.ventosa.Day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day1 extends Day {
    List<Integer> listOne = new ArrayList<>();
    List<Integer>  listTwo = new ArrayList<>();

    public Day1(String inputFile) {
        super(inputFile);
        for (String s: input) {
            var split = s.split("   ");
            listOne.add(Integer.parseInt(split[0]));
            listTwo.add(Integer.parseInt(split[1]));
        }
    }

    public Integer part1() {
        var sortedListOne = listOne.stream().sorted().toList();
        var sortedListTwo = listTwo.stream().sorted().toList();
        var result = 0;
        for (int i = 0; i < sortedListOne.size(); i++) {
            result += Math.abs(sortedListOne.get(i) - sortedListTwo.get(i));
        }
        return result;
    }

    public Integer part2() {
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
        return result;
    }
}