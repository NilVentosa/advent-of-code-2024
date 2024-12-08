package xyz.ventosa.day8;

import xyz.ventosa.Day;
import xyz.ventosa.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day8 extends Day  {
    List<List<String>> map = Utils.getListOfList(input);
    Map<String, List<Point>> frequencies = new HashMap<>();

    public Day8(String inputFile) {
        super(inputFile);
        for (int y = 0; y < map.size(); y++) {
            for (int x = 0; x < map.get(y).size(); x++) {
                String frequency = map.get(y).get(x);
                if (!frequency.equals(".")) {
                    frequencies.putIfAbsent(frequency, new ArrayList<>());
                    frequencies.get(frequency).add(new Point(x, y));
                }
            }
        }
    }

    @Override
    public Object part1() {
        var differentFrequencies = frequencies.keySet();
        Set<Point> antennas = new HashSet<>();
        for (String frequency : differentFrequencies) {
            for (int i = 0; i < frequencies.get(frequency).size(); i++) {
                for (int j = 0; j < frequencies.get(frequency).size(); j++) {
                    if (i != j) {
                        var f1 = frequencies.get(frequency).get(i);
                        var f2 = frequencies.get(frequency).get(j);
                        var dX = f1.x - f2.x;
                        var dY = f1.y - f2.y;
                        antennas.add(new Point(f2.x - dX, f2.y - dY));
                    }
                }
            }
        }
        antennas.removeIf(point -> !point.isInMap(map));
        return antennas.size();
    }

    @Override
    public Object part2() {
        var differentFrequencies = frequencies.keySet();
        Set<Point> antennas = new HashSet<>();
        for (String frequency : differentFrequencies) {
            for (int i = 0; i < frequencies.get(frequency).size(); i++) {
                for (int j = 0; j < frequencies.get(frequency).size(); j++) {
                    if (i != j) {
                        var f1 = frequencies.get(frequency).get(i);
                        var f2 = frequencies.get(frequency).get(j);
                        antennas.add(f1);
                        var dX = f1.x - f2.x;
                        var dY = f1.y - f2.y;
                        var newAntenna = new Point(f2.x - dX, f2.y - dY);
                        while (newAntenna.isInMap(map)) {
                            antennas.add(newAntenna);
                            newAntenna = new Point(newAntenna.x - dX, newAntenna.y - dY);
                        }
                    }
                }
            }
        }
        return antennas.size();
    }

    record Point(int x, int y) {
        boolean isInMap(List<List<String>> map) {
            return x >= 0 && y >= 0 && x < map.getFirst().size() && y < map.size();
        }
    }

}
