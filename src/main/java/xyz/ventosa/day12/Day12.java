package xyz.ventosa.day12;

import xyz.ventosa.Day;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day12 extends Day  {
    List<List<Character>> land = input.stream()
            .map(s -> s.chars().mapToObj(c -> (char) c).toList())
            .toList();
    Set<Island> islands = new HashSet<>();
    Map<Island, Set<PerimeterUnit>> perimeters = new HashMap<>();

    public Day12(String inputFile) {
        super(inputFile);
        for (int x = 0; x < land.getFirst().size(); x++) {
            for (int y = 0; y < land.size(); y++) {
                islands.add(new Island(land.get(y).get(x), getConnections(new Point(x, y), new HashSet<>())));
            }
        }
    }

    @Override
    public Object part1() {
        var result = 0;
        for (Island island: islands) {;
            result += calculatePointPerimeter(island) * island.points.size();
        }
        return result;
    }

    Set<Point> getConnections(Point p, Set<Point> soFar) {
        Set<Point> partialResult = new HashSet<>();
        partialResult.add(p);
        var value = land.get(p.y).get(p.x);
        if (p.x > 0 && land.get(p.y).get(p.x - 1) == value) {
            partialResult.add(new Point(p.x - 1, p.y));
        }
        if (p.x < land.getFirst().size() - 1 && land.get(p.y).get(p.x + 1) == value) {
            partialResult.add(new Point(p.x + 1, p.y));
        }
        if (p.y > 0 && land.get(p.y - 1).get(p.x) == value) {
            partialResult.add(new Point(p.x, p.y - 1));
        }
        if (p.y < land.size() - 1 && land.get(p.y + 1).get(p.x) == value) {
            partialResult.add(new Point(p.x, p.y + 1));
        }

        for (Point point : partialResult) {
            if (soFar.contains(point)) {
                continue;
            }
            soFar.add(point);
            soFar.addAll(getConnections(point, soFar));
        }
        return soFar;
    }

    int calculatePointPerimeter(Island island) {
        var result = 0;
        var perimeterUnits = new HashSet<PerimeterUnit>();
        for (Point point: island.points) {
            char c = land.get(point.y).get(point.x);
            int per = 0;
            if (point.x == 0 || land.get(point.y).get(point.x - 1) != c) {
                per++;
                perimeterUnits.add(new PerimeterUnit(point, Direction.LEFT));
            }
            if (point.x >= land.getFirst().size() - 1 || land.get(point.y).get(point.x + 1) != c) {
                per++;
                perimeterUnits.add(new PerimeterUnit(point, Direction.RIGHT));
            }
            if (point.y == 0 || land.get(point.y - 1).get(point.x) != c) {
                per++;
                perimeterUnits.add(new PerimeterUnit(point, Direction.UP));
            }
            if (point.y >= land.size() - 1 || land.get(point.y + 1).get(point.x) != c) {
                per++;
                perimeterUnits.add(new PerimeterUnit(point, Direction.DOWN));
            }
            result += per;
        }
        perimeters.put(island, perimeterUnits);
        return result;
    }

    @Override
    public Object part2() {
        for (Island island: islands) {
            int i = calculatePointPerimeter(island) * island.points.size();
        }
        var result = 0;
        for (Island island: islands) {
            var sides = calculateSides(island);
            result += sides * island.points.size();
        }
        return result;
    }

    int calculateSides(Island island) {
        var perimeterUnits = perimeters.get(island);
        var result = new HashSet<Side>();
        var nextSide = 0;
        var side = new Side(nextSide, new HashSet<>());
        for (PerimeterUnit pu: perimeterUnits) {

        }
        return result.size();
    }
    
    record Point(int x, int y) { }
    record Island(char value, Set<Point> points) { }
    enum Direction { UP, DOWN, LEFT, RIGHT }
    record PerimeterUnit(Point point, Direction direction) { }
    record Side(int id, Set<PerimeterUnit> units) { }
}
