package xyz.ventosa.day11;

import xyz.ventosa.Day;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day11 extends Day  {

    Map<Pair, BigInteger> itemLengths = new HashMap<>();

    public Day11(String inputFile) {
        super(inputFile);
    }

    @Override
    public Object part1() {
        return solve(25);
    }

    @Override
    public Object part2() {
        return solve(75);
    }

    record Pair(String item, Integer times) {}

    BigInteger solve(int times) {
        var items = input.getFirst().split(" ");
        return Arrays.stream(items)
                .map(item -> solveItem(item, times))
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    BigInteger solveItem(String item, int times) {
        BigInteger toReturn;
        if (itemLengths.containsKey(new Pair(item, times))) {
            return itemLengths.get(new Pair(item, times));
        } else if (times == 0) {
            toReturn = BigInteger.ONE;
        } else if (new BigInteger(item).equals(BigInteger.ZERO)) {
            toReturn = solveItem("1", times - 1);
        } else if (item.length() % 2 == 0) {
            var left = item.substring(0, item.length() / 2);
            var right = new BigInteger(item.substring(item.length()/2)).toString();
            toReturn = solveItem(right, times-1).add(solveItem(left, times-1));
        } else {
            toReturn = solveItem((new BigInteger(item).multiply(new BigInteger("2024"))).toString(), times - 1);
        }

        itemLengths.put(new Pair(item, times), toReturn);

        return toReturn;
    }
}
