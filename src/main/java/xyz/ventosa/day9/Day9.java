package xyz.ventosa.day9;

import xyz.ventosa.Day;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day9 extends Day  {
    List<Integer> splitInput;

    public Day9(String inputFile) {
        super(inputFile);
        splitInput = Arrays.stream(input.getFirst().split("")).map(Integer::parseInt).toList();
    }

    @Override
    public Object part1() {
        List<Integer> thing = new ArrayList<>();
        int minuses = 0;
        for (int i = 0; i*2 < splitInput.size(); i++) {
            for (int j = 0; j < splitInput.get(i*2); j++) {
                thing.add(i);
            }
            if (i+i+1 < splitInput.size()) {
                for (int j = 0; j < splitInput.get(i+i+1); j++) {
                    thing.add(-1);
                    minuses++;
                }
            }
        }
        for (int i = 0; i < minuses; i++) {
            int last = lastNonMinusOneIndex(thing);
            thing.set(thing.indexOf(-1), thing.get(last));
            thing.set(last, -1);
        }
        while (thing.contains(-1)) {
            thing.remove(thing.indexOf(-1));
        }

        BigInteger result = BigInteger.valueOf(0);
        for (int i = 0; i < thing.size(); i++) {
            result = result.add(BigInteger.valueOf(thing.get(i) * i));
        }
        return result;
    }

    @Override
    public Object part2() {
        List<Integer> thing = new ArrayList<>();
        for (int i = 0; i*2 < splitInput.size(); i++) {
            for (int j = 0; j < splitInput.get(i*2); j++) {
                thing.add(i);
            }
            if (i+i+1 < splitInput.size()) {
                for (int j = 0; j < splitInput.get(i+i+1); j++) {
                    thing.add(-1);
                }
            }
        }

        int current = thing.getLast();
        int currentCount = 1;
        for (int i = thing.size() - 1; i >= 0; i--) {
            if (thing.get(i) == -1) {
                continue;
            } else {
                current = thing.get(i);
            }
            if (thing.get(i) == current) {
                currentCount++;
            } else {
                var spot = firstAvailableIndex(thing, currentCount);
                if (spot != -1) {
                    for (int j = 0; j < currentCount; j++) {
                        thing.set(spot + j, current);
                        thing.set(i + j, -1);
                    }
                }
                currentCount = 1;
            }
        }

        return thing;
    }

    int lastNonMinusOneIndex(List<Integer> list) {
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i) != -1) {
                return i;
            }
        }
        return -1;
    }

    static int firstAvailableIndex(List<Integer> list, int size) {
        var count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (count == size) {
                return i - count;
            }
            if (list.get(i) == -1) {
                count++;
            } else {
                count = 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstAvailableIndex(Arrays.asList(1, 2, 1, -1, 3, 4, -1, -1, 6, 7), 2));
    }
}
