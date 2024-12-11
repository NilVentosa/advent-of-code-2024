package xyz.ventosa.day10;

import xyz.ventosa.Day;
import xyz.ventosa.Utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day10 extends Day  {
    List<List<Integer>> map =
            Utils.getListOfList(input).stream()
                    .map(l -> l.stream().map(Integer::parseInt).toList())
                    .toList();

    Set<Pair> pairs = new HashSet<>();

    public Day10(String inputFile) {
        super(inputFile);
    }

    @Override
    public Object part1() {
        for (int x = 0; x < map.getFirst().size(); x++) {
            for (int y = 0; y < map.size(); y++) {
                if (map.get(y).get(x) == 0) {
                    for (Point point: solve(x, y, 0, new HashSet<>())) {
                        pairs.add(new Pair(new Point(x, y), point));
                    }
                }
            }
        }
        return pairs.size();
    }

    Set<Point> solve(int x, int y, int current, Set<Point> points) {
        var north = y - 1 >= 0 ? map.get(y - 1).get(x) : -1;
        var south = y + 1 < map.size() ? map.get(y + 1).get(x) : -1;
        var east = x + 1 < map.getFirst().size() ? map.get(y).get(x + 1) : -1;
        var west = x - 1 >= 0 ? map.get(y).get(x - 1) : -1;

        if (current == 9) {
            points.add(new Point(x, y));
            return points;
        } else {
            if (north == current + 1) {
                points.addAll(solve(x, y - 1, current + 1, points));
            }
            if (south == current + 1) {
                points.addAll(solve(x, y + 1, current + 1, points));
            }
            if (east == current + 1) {
                points.addAll(solve(x + 1, y, current + 1, points));
            }
            if (west == current + 1) {
                points.addAll(solve(x - 1, y, current + 1, points));
            }
        }
        return points;
    }

    @Override
    public Object part2() {
        int result = 0;
        for (int x = 0; x < map.getFirst().size(); x++) {
            for (int y = 0; y < map.size(); y++) {
                if (map.get(y).get(x) == 0) {
                    result += solve2(x, y, 0);
                }
            }
        }
        return result;
    }

    int solve2(int x, int y, int current) {
        var north = y - 1 >= 0 ? map.get(y - 1).get(x) : -1;
        var south = y + 1 < map.size() ? map.get(y + 1).get(x) : -1;
        var east = x + 1 < map.getFirst().size() ? map.get(y).get(x + 1) : -1;
        var west = x - 1 >= 0 ? map.get(y).get(x - 1) : -1;

        int toReturn = 0;
        if (current == 9) {
            return 1;
        } else {
            if (north == current + 1) {
                toReturn += solve2(x, y - 1, current + 1);
            }
            if (south == current + 1) {
                toReturn += solve2(x, y + 1, current + 1);
            }
            if (east == current + 1) {
                toReturn += solve2(x + 1, y, current + 1);
            }
            if (west == current + 1) {
                toReturn += solve2(x - 1, y, current + 1);
            }
        }
        return toReturn;

    }

    record Point(int x, int y) { }

    record Pair(Point a, Point b) { }
}
