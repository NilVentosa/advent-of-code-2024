package xyz.ventosa.day13;

import xyz.ventosa.Day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day13 extends Day  {

    private final List<Machine> machines = new ArrayList<>();

    public Day13(String inputFile) {
        super(inputFile);
        Button buttonA = null;
        Button buttonB = null;
        for (String line : input) {
            if (line.startsWith("Button")) {
                int x = Integer.parseInt(line.split("X\\+")[1].split(",")[0]);
                int y = Integer.parseInt(line.split("Y\\+")[1]);
                if (line.charAt(7) == 'A') {
                    buttonA = new Button(ButtonType.A, x, y);
                } else {
                    buttonB = new Button(ButtonType.B, x, y);
                }
            } else if (line.startsWith("Prize")) {
                int x = Integer.parseInt(line.split(",")[0].split("X=")[1]);
                int y = Integer.parseInt(line.split("Y=")[1]);
                machines.add(new Machine(buttonA, buttonB, x, y));
            }
        }
    }

    Map<XY, Integer> cache = new HashMap<>();
    @Override
    public Object part1() {
        var result = 0;
        for (Machine machine : machines) {
            cache.clear();
            result += solve(machine);
        }
        return result;
    }

    int solve(Machine m) {
        var result = solve(m.prizeX, m.prizeY, m);
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }

    int solve(int x, int y, Machine machine) {
        if (cache.containsKey(new XY(x, y))) {
            return cache.get(new XY(x, y));
        } else if (x == 0 && y == 0) {
            return 0;
        } else if (x < 0) {
            return Integer.MAX_VALUE;
        } else if (y < 0) {
            return Integer.MAX_VALUE;
        } else {
            int result = Math.min(solve(x - machine.a.x, machine.a.y, machine) + 3, solve(x - machine.b.x, y - machine.b.y, machine) + 1);
            cache.put(new XY(x, y), result);
            return result;
        }
    }

    @Override
    public Object part2() {
        return null;
    }

    record Machine(Button a, Button b, int prizeX, int prizeY) {}
    record Button(ButtonType type, int x, int y) { }
    enum ButtonType { A, B }
    record XY(int x, int y) { }
}
