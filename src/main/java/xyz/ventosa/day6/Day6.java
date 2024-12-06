package xyz.ventosa.day6;

import xyz.ventosa.Day;
import xyz.ventosa.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Day6 extends Day  {
    List<List<String>> map = Utils.getListOfList(input);
    private static final String GUARD = "^";
    private static final String STUFF = "#";
    private static final List<Direction> directions = List.of(
            new Direction(0, -1),
            new Direction(1, 0),
            new Direction(0, 1),
            new Direction(-1, 0)
    );
    Position initialGuardPosition;

    public Day6(String inputFile) {
        super(inputFile);
        for (int y = 0; y < map.size(); y++) {
            for (int x = 0; x < map.getFirst().size(); x++) {
                if (map.get(y).get(x).equals(GUARD)) {
                    initialGuardPosition = new Position(x, y);
                }
            }
        }
    }

    @Override
    public Object part1() {
        var currentDirection = 0;
        Position currentPosition = initialGuardPosition;
        var visited = new HashSet<Position>();
        while (currentPosition.isInMap(map)) {
            visited.add(currentPosition);
            var nextPosition = currentPosition.move(directions.get(currentDirection));
            if (nextPosition.isInMap(map) && map.get(nextPosition.y).get(nextPosition.x).equals(STUFF)) {
                currentDirection = nextDirection(currentDirection);
            }
            currentPosition = currentPosition.move(directions.get(currentDirection));
        }
        return visited.size();
    }

    @Override
    public Object part2() {
        return null;
    }

    record Direction(int x, int y) {}

    record Position(int x, int y) {
        boolean isInMap(List<List<String>> map) {
            return x >= 0 && x < map.getFirst().size() && y >= 0 && y < map.size();
        }
        Position move(Direction direction) {
            return new Position(x + direction.x(), y + direction.y());
        }
    }

    static int nextDirection(int currentDirection) {
        return currentDirection + 1 == directions.size() ? 0 : currentDirection + 1;
    }

    static List<List<String>> addStuffToMap(Position pos, List<List<String>> map) {
        var newMap = new ArrayList<>(map);
        var newRow = new ArrayList<>(map.get(pos.y));
        newRow.set(pos.x, STUFF);
        newMap.set(pos.y, newRow);
        return newMap;
    }
}
