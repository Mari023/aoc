package year2024.day07;

import java.util.ArrayList;
import java.util.List;

public class Day07 {
    public static void main() {
        long result = 0;
        List<Equation> equations = new ArrayList<>();
        for (String s : Input.INPUT.split("\n")) {
            var e = Equation.fromString(s);
            equations.add(e);
            if (e.isValid()) {
                result += e.result();
            }
        }
        System.out.println(result);
        Equation.part2 = true;
        result = 0;
        for (Equation e : equations) {
            if (e.isValid()) {
                result += e.result();
            }
        }
        System.out.println(result);
    }
}
