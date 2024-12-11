package xyz.ventosa.day9;

import xyz.ventosa.Day;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day9 extends Day  {
    List<Integer> splitInput;
    List<Integer> disk;

    public Day9(String inputFile) {
        super(inputFile);
        splitInput = Arrays.stream(input.getFirst().split("")).map(Integer::parseInt).toList();
        disk = new ArrayList<>();
        for (int i = 0; i*2 < splitInput.size(); i++) {
            for (int j = 0; j < splitInput.get(i*2); j++) {
                disk.add(i);
            }
            if (i+i+1 < splitInput.size()) {
                for (int j = 0; j < splitInput.get(i+i+1); j++) {
                    disk.add(-1);
                }
            }
        }
    }

    @Override
    public Object part1() {
        List<Integer> thing = new ArrayList<>(disk);
        int minuses = 0;
        for (Integer integer : disk) {
            if (integer == -1) {
                minuses++;
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
        var newDisk = new ArrayList<>(disk);
        for (int i = disk.getLast(); i > 0; i--) {
            int instances = countInstances(i);
            int availableIndex = firstAvailableIndex(newDisk, instances);
            if (availableIndex != -1 && availableIndex < disk.indexOf(i)) {
                for (int j = 0; j < newDisk.size(); j++) {
                    if (newDisk.get(j) == i) {
                        newDisk.set(j, -1);
                    }
                }
                for (int j = 0; j < instances; j++) {
                    newDisk.set(availableIndex+j, i);
                }
            }
        }
        BigInteger result = BigInteger.valueOf(0);
        for (int i = 0; i < newDisk.size(); i++) {
            if (newDisk.get(i) != -1) {
                result = result.add(BigInteger.valueOf(newDisk.get(i) * i));
            }
        }
        return result;
    }

    int lastNonMinusOneIndex(List<Integer> list) {
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i) != -1) {
                return i;
            }
        }
        return -1;
    }

    int countInstances(int value) {
        int count = 0;
        for (Integer integer : disk) {
            if (integer == value) {
                count++;
            }
        }
        return count;
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
}
