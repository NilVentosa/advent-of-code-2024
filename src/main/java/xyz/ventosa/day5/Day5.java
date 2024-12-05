package xyz.ventosa.day5;

import xyz.ventosa.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5 extends Day  {
    List<Rule> rules = new ArrayList<>();
    List<Update> updates = new ArrayList<>();

    public Day5(String inputFile) {
        super(inputFile);
        for (String line: input) {
            if (line.isEmpty()) {
                continue;
            }
            if (line.contains("|")) {
                String[] parts = line.split("\\|");
                int first = Integer.parseInt(parts[0]);
                int second = Integer.parseInt(parts[1]);
                rules.add(new Rule(first, second));
            } else {
                String[] parts = line.split(",");
                List<Integer> pages = Arrays.stream(parts).map(Integer::parseInt).toList();
                updates.add(new Update(pages));
            }
        }
    }

    @Override
    public Object part1() {
        var result = 0;
        for (Update update: updates) {
            var satisfiesRules = true;
            for (Rule rule: rules) {
                if (update.pages.contains(rule.first) && update.pages.contains(rule.second) &&
                        update.pages.indexOf(rule.first) >= update.pages.indexOf(rule.second)) {
                    satisfiesRules = false;
                }
            }
            if (satisfiesRules) {
                result += update.getMiddle();
            }
        }
        return result;
    }

    @Override
    public Object part2() {
        var result = 0;
        for (Update update: updates) {
            var wasFixed = false;
            for (Rule rule: rules) {
                if (update.pages.contains(rule.first) && update.pages.contains(rule.second) &&
                        update.pages.indexOf(rule.first) > update.pages.indexOf(rule.second)) {
                    update = fixIt(update);
                    wasFixed = true;
                }
            }
            if (wasFixed) {
                result += update.getMiddle();
            }
        }
        return result;
    }

    record Rule(int first, int second) { }

    Update fixIt(Update update) {
        for (Rule rule: rules) {
            if (update.pages.contains(rule.first) && update.pages.contains(rule.second) &&
                    update.pages.indexOf(rule.first) > update.pages.indexOf(rule.second)) {
                update = update.changePlaces(update.pages.indexOf(rule.first), update.pages.indexOf(rule.second));
                return fixIt(update);
            }
        }
        return update;
    }

    record Update(List<Integer> pages) {
        Update changePlaces(int firstIndex, int secondIndex) {
            List<Integer> newPages = new ArrayList<>(pages);
            newPages.set(firstIndex, pages.get(secondIndex));
            newPages.set(secondIndex, pages.get(firstIndex));
            return new Update(newPages);
        }

        int getMiddle() {
            return pages.get(pages.size() / 2);
        }
    }
}
