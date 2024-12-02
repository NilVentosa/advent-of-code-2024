package xyz.ventosa.day2;

import xyz.ventosa.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Day2 extends Day  {
    public Day2(String inputFile) {
        super(inputFile);
    }

    @Override
    public Object part1() {
        var result = 0;
        for (String line: input) {
            var split = Arrays.stream(line.split(" ")).map(Integer::parseInt).toList();
            if (doesItMatchCriteria(split)) {
                result ++;
            }
        }
        return result;
    }

    private static boolean isAscending(Integer first, Integer second, List<Integer> ints) {
        return ints.get(first) < ints.get(second);
    }

    private static boolean doesItMatchCriteria(List<Integer> list) {
        var prev = list.getFirst();
        for (int i = 1; i < list.size(); i++) {
            if (Objects.equals(prev, list.get(i))) {
                return false;
            }
            if (Math.abs(prev - list.get(i)) > 3) {
                return false;
            }
            if (isAscending(0, 1, list) != isAscending(i - 1, i, list)) {
                return false;
            }
            prev = list.get(i);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(doesItMatchCriteria(List.of(8,6,4,4,1)));
    }

    @Override
    public Object part2() {
        var result = 0;
        for (String line: input) {
            var split = Arrays.stream(line.split(" ")).map(Integer::parseInt).toList();
            if (doesItMatchCriteria(split)) {
                result ++;
            } else {
                for (int i = 0; i < split.size(); i++) {
                    var splitCopy = new ArrayList<>(split);
                    splitCopy.remove(i);
                    if (doesItMatchCriteria(splitCopy)) {
                        result ++;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
