package year2024.day05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day05 {
    public static void main() {
        String[] input = Input.TEST.split("\n\n");
        String[] rules = input[0].split("\n");
        String[] updates = input[1].split("\n");

        Map<Integer, List<Rule>> ruleMap = new HashMap<>();

        for (String s : rules) {
            var r = s.split("\\|");
            var rule = new Rule(Integer.parseInt(r[0]), Integer.parseInt(r[1]));
            if (!ruleMap.containsKey(rule.first())) {
                ruleMap.put(rule.first(), new ArrayList<>());
            }
            ruleMap.get(rule.first()).add(rule);
        }

        List<List<Integer>> updateList = new ArrayList<>();
        List<List<Integer>> incorrectUpdates = new ArrayList<>();
        for (String s : updates) {
            var strings = s.split(",");
            List<Integer> update = new ArrayList<>();
            for (String u : strings) {
                update.add(Integer.parseInt(u));
            }
            updateList.add(update);

            updateLoop:
            for (int i = 0; i < update.size(); i++) {
                var u = update.get(i);
                if (!ruleMap.containsKey(u)) continue;
                for (Rule rule : ruleMap.get(u)) {
                    var second = update.indexOf(rule.second());
                    if (second != -1 && second < i) {
                        updateList.remove(update);
                        incorrectUpdates.add(update);
                        break updateLoop;
                    }
                }
            }
        }

        sum(updateList);
        part2(ruleMap, incorrectUpdates);
    }

    private static void part2(Map<Integer, List<Rule>> rules, List<List<Integer>> updates) {
        for (List<Integer> rule : updates) {
            rule.sort((a, b) -> compareUpdates(a, b, rules));
        }
        sum(updates);
    }

    private static int compareUpdates(int a, int b, Map<Integer, List<Rule>> rules) {
        if(rules.containsKey(a)) {
            for (var rule : rules.get(a)) {
                if (rule.second() == b) return 1;
            }
        }
        if(rules.containsKey(b)) {
            for (var rule : rules.get(b)) {
                if (rule.second() == b) return -1;
            }
        }
        return 0;
    }

    private static void sum(List<List<Integer>> updates) {
        long result = 0;
        for (var update : updates) {
            result += update.get(update.size() / 2);
        }
        System.out.println(result);
    }
}
