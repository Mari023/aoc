package year2024.day03;

import java.util.regex.Pattern;

public class Day03 {
    private static final Pattern numbers = Pattern.compile("[0-9]+");

    public static void main() {
        var multiplication = Pattern.compile("mul\\([0-9]+,[0-9]+\\)");
        var matcher = multiplication.matcher(Input.INPUT);
        long result = 0;
        while (matcher.find()) {
            result += mul(matcher.group());
        }
        System.out.println(result);

        part2();
    }

    private static void part2() {
        var multiplication = Pattern.compile("mul\\([0-9]+,[0-9]+\\)|do\\(\\)|don't\\(\\)");
        var matcher = multiplication.matcher(Input.INPUT);
        long result = 0;
        boolean enabled = true;
        while (matcher.find()) {
            var currentString = matcher.group();
            switch (currentString) {
                case "do()" -> enabled = true;
                case "don't()" -> enabled = false;
                default -> {
                    if (!enabled) continue;
                    result += mul(currentString);
                }
            }
        }
        System.out.println(result);
    }

    private static long mul(String instruction) {
        var numbersMatcher = numbers.matcher(instruction);
        if (!numbersMatcher.find()) throw new IllegalStateException("Couldn't find number, this is impossible");
        long a = Long.parseLong(numbersMatcher.group());
        if (!numbersMatcher.find()) throw new IllegalStateException("Couldn't find number, this is impossible");
        long b = Long.parseLong(numbersMatcher.group());
        return a * b;
    }
}
