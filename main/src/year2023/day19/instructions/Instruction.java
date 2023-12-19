package year2023.day19.instructions;

import year2023.day19.Part;

import java.util.ArrayList;
import java.util.List;

public record Instruction(String name, List<Rule> rules) {
    public Result apply(Part part) {
        for (Rule rule : rules) {
            if (rule.matches(part)) return rule.result();
        }
        throw new IllegalStateException("Part: " + part + " did not match any rule in Instruction " + name() + " " + this);
    }

    public static Instruction of(String string) {
        var v = string.split("\\{");
        String name = v[0];
        String[] ruleStrings = v[1].substring(0, v[1].length() - 1).split(",");
        List<Rule> rules = new ArrayList<>();
        for (String s : ruleStrings) {
            rules.add(Rule.of(s));
        }
        return new Instruction(name, rules);
    }
}
