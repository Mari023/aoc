package year2024.day03;

import java.util.regex.Pattern;

public class Day03 {
    public static void main() {
        var multiplication = Pattern.compile("mul\\([0-9]+,[0-9]+\\)");
        var matcher = multiplication.matcher(Input.INPUT);
        var numbers = Pattern.compile("[0-9]+");
        long result = 0;
        while (matcher.find()) {
            var numbersMatcher = numbers.matcher(matcher.group());
            if (!numbersMatcher.find()) throw new IllegalStateException("Couldn't find number, this is impossible");
            long a = Long.parseLong(numbersMatcher.group());
            if (!numbersMatcher.find()) throw new IllegalStateException("Couldn't find number, this is impossible");
            long b = Long.parseLong(numbersMatcher.group());
            result += a * b;
        }
        System.out.println(result);
    }
}
