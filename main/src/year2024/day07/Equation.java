package year2024.day07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record Equation(long result, List<Integer> values) {
    public static boolean part2 = false;
    public static final Map<Equation, Long> workingOperators = new HashMap<>();

    public boolean isValid() {
        long sum = 0;
        long product = 1;
        for (var value : values) {
            sum += value;
            product *= value;
        }
        if (product == result || sum == result) {
            workingOperators.put(this, -1L);
            return true;
        }

        if (values().size() > 65) throw new IllegalStateException("Can't work with more than 64 operators");
        else if (part2 && values().size() > 33)
            throw new IllegalStateException("Can't work with more than 33 operators");
        long maxOperator = 1L << (values.size() - 1);
        if (part2)
            maxOperator = 1L << ((values.size() - 1) * 2);
        for (long operators = 0; operators < maxOperator; operators++) {
            if ((!part2 && test(operators)) || (part2 && test2(operators))) {
                workingOperators.put(this, operators);
                return true;
            }
        }
        return false;
    }

    public static Equation fromString(String equation) {
        var strings = equation.split(":");
        long result = Long.parseLong(strings[0]);
        strings = strings[1].trim().split(" ");
        var values = new ArrayList<Integer>();
        for (String string : strings) {
            values.add(Integer.parseInt(string));
        }
        return new Equation(result, List.copyOf(values));
    }

    private boolean test(long operators) {
        long l = values().getFirst();
        for (int i = 1; i < values().size(); i++) {
            if (((operators >> (i - 1)) & 1) == 0)
                l += values().get(i);
            else l *= values().get(i);
        }
        return result() == l;
    }

    private boolean test2(long operators) {
        long l = values().getFirst();
        for (int i = 1; i < values().size(); i++) {
            int nextValue = values().get(i);
            switch (((operators >> (2 * (i - 1))) & 0b11)) {
                case 0L -> l += nextValue;
                case 1L -> l *= nextValue;
                case 2L -> l = Long.parseLong(l + "" + nextValue);
                default -> {
                    return false;
                }
            }
        }
        return result() == l;
    }
}
