package year2024.day07;

public class Day07 {
    public static void main() {
        long result = 0;
        for (String s : Input.INPUT.split("\n")) {
            var e = Equation.fromString(s);
            if (e.isValid()) {
                result += e.result();
            }
        }
        System.out.println(result);
    }
}
