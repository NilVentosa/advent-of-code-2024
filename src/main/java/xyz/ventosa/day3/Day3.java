package xyz.ventosa.day3;

import xyz.ventosa.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 extends Day  {
    public Day3(String inputFile) {
        super(inputFile);
    }

    @Override
    public Object part1() {
        String regex = "mul\\(\\d+,\\d+\\)";
        List<String> matches = extractMatchingSubstrings(input, regex);
        var result = 0;
        for (String match : matches) {
            result += multiplyMatch(match);
        }
        return result;
    }

    public static List<String> extractMatchingSubstrings(List<String> input, String regex) {
        List<String> matches = new ArrayList<>();
        for (String s: input) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(s);

            while (matcher.find()) {
                matches.add(matcher.group());
            }
        }

        return matches;
    }

    public static Integer multiplyMatch(String match) {
        String[] split = match.substring(4,match.length() - 1).split(",");
        return Integer.parseInt(split[0]) * Integer.parseInt(split[1]);
    }

    @Override
    public Object part2() {
        String regex = "mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)";
        List<String> matches = extractMatchingSubstrings(input, regex);
        var result = 0;
        boolean state = true;
        for (String match : matches) {
            if (match.equals("do()")) {
                state = true;
                continue;
            } else if (match.equals("don't()")) {
                state = false;
                continue;
            }
            if (state) {
                result += multiplyMatch(match);
            }
        }
        return result;
    }
}
