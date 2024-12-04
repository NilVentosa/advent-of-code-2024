package xyz.ventosa.day4;

import xyz.ventosa.Day;
import xyz.ventosa.Utils;

import java.util.List;

public class Day4 extends Day  {
    public Day4(String inputFile) {
        super(inputFile);
    }

    @Override
    public Object part1() {
        var split = Utils.getListOfList(input);
        var result = 0;
        for (int i = 0; i < split.size(); i++) {
            for (int j = 0; j < split.get(i).size(); j++) {
                result += howManyStartHere(split, j, i);
            }
        }
        return result;
    }

    int howManyStartHere(List<List<String>> split, int x, int y) {
        var result = 0;
        if (!split.get(y).get(x).equals("X")) {
            return result;
        }
        try {
            if (split.get(y).get(x + 1).equals("M") && split.get(y).get(x + 2).equals("A") && split.get(y).get(x + 3).equals("S")) {
                result++;
            }
        } catch (IndexOutOfBoundsException e) {}
        try {
            if (split.get(y).get(x - 1).equals("M") && split.get(y).get(x - 2).equals("A") && split.get(y).get(x - 3).equals("S")) {
                result++;
            }
        } catch (IndexOutOfBoundsException e) {}
        try {
            if (split.get(y + 1).get(x).equals("M") && split.get(y + 2).get(x).equals("A") && split.get(y + 3).get(x).equals("S")) {
                result++;
            }
        } catch (IndexOutOfBoundsException e) {}
        try {
            if (split.get(y - 1).get(x).equals("M") && split.get(y - 2).get(x).equals("A") && split.get(y - 3).get(x).equals("S")) {
                result++;
            }
        } catch (IndexOutOfBoundsException e) {}
        try {
            if (split.get(y+1).get(x+1).equals("M") && split.get(y+2).get(x+2).equals("A") && split.get(y+3).get(x+3).equals("S")) {
                result++;
            }
        } catch (IndexOutOfBoundsException e) {}
        try {
            if (split.get(y-1).get(x-1).equals("M") && split.get(y-2).get(x-2).equals("A") && split.get(y-3).get(x-3).equals("S")) {
                result++;
            }
        } catch (IndexOutOfBoundsException e) {}
        try {
            if (split.get(y+1).get(x-1).equals("M") && split.get(y+2).get(x-2).equals("A") && split.get(y+3).get(x-3).equals("S")) {
                result++;
            }
        } catch (IndexOutOfBoundsException e) {}
        try {
            if (split.get(y-1).get(x+1).equals("M") && split.get(y-2).get(x+2).equals("A") && split.get(y-3).get(x+3).equals("S")) {
                result++;
            }
        } catch (IndexOutOfBoundsException e) {}
        return result;
    }

    @Override
    public Object part2() {
        var split = Utils.getListOfList(input);
        var result = 0;
        for (int i = 0; i < split.size(); i++) {
            for (int j = 0; j < split.get(i).size(); j++) {
                if (crossStartsHere(split, j, i)) {
                    result++;
                }
            }
        }
        return result;
    }

    boolean crossStartsHere(List<List<String>> split, int x, int y) {
        var result = 0;
        if (!split.get(y).get(x).equals("A")) {
            return false;
        }
        if (x == 0 || y == 0 || x == split.getFirst().size() - 1 || y == split.size() - 1) {
            return false;
        }
        if (split.get(y + 1).get(x + 1).equals("M") && split.get(y - 1).get(x - 1).equals("S")) {
            result++;
        }
        if (split.get(y - 1).get(x - 1).equals("M") && split.get(y + 1).get(x + 1).equals("S")) {
            result++;
        }
        if (split.get(y + 1).get(x - 1).equals("M") && split.get(y - 1).get(x + 1).equals("S")) {
            result++;
        }
        if (split.get(y - 1).get(x + 1).equals("M") && split.get(y + 1).get(x - 1).equals("S")) {
            result++;
        }
        return result > 1;
    }
}
