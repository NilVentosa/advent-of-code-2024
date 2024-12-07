package xyz.ventosa.day7;

import xyz.ventosa.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day7 extends Day  {
    List<Equation> equations = new ArrayList<>();

    public Day7(String inputFile) {
        super(inputFile);
        for (String line: input) {
            var parts = line.split(": ");
            equations.add(new Equation(
                    Long.parseLong(parts[0]),
                    Stream.of(parts[1].split(" ")).map(Long::parseLong).toList())
            );
        }
    }

    @Override
    public Object part1() {
        long result = 0;
        for (Equation equation: equations) {
            var combinations = generateCombinations(new String[]{"*", "+"}, equation.numbers.size() - 1);
            for (List<String> combination: combinations) {
                long partialResult = calculateEquation(equation, combination);
                if (partialResult == equation.result) {
                    result += partialResult;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Object part2() {
        long result = 0;
        for (Equation equation: equations) {
            var combinations = generateCombinations(new String[]{"*", "+", "||"}, equation.numbers.size() - 1);
            for (List<String> combination: combinations) {
                long partialResult = calculateEquation(equation, combination);
                if (partialResult == equation.result) {
                    result += partialResult;
                    break;
                }
            }
        }
        return result;
    }

    private static long calculateEquation(Equation equation, List<String> combination) {
        long partialResult = equation.numbers.getFirst();
        for (int i = 0; i < combination.size(); i++) {
            if (combination.get(i).equals("+")) {
                partialResult += equation.numbers.get(i + 1);
            } else if (combination.get(i).equals("*")) {
                partialResult *= equation.numbers.get(i + 1);
            } else {
                partialResult = Long.parseLong(String.valueOf(partialResult) + equation.numbers.get(i + 1));
            }
        }
        return partialResult;
    }

    record Equation(long result, List<Long> numbers) {}

    public static List<List<String>> generateCombinations(String[] symbols, int length) {
        var totalCombinations = Math.pow(symbols.length, length);
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < totalCombinations; i++) {
            List<String> combination = new ArrayList<>();
            int temp = i;

            for (int j = 0; j < length; j++) {
                combination.add(symbols[temp % symbols.length]);
                temp = temp / symbols.length;
            }
            result.add(combination);
        }
        return result;
    }
}
