package year2024.day04;

import java.util.regex.Pattern;

public class Day04Part2 {
    public static void main() {
        String input = Input.INPUT;
        int i = input.split("\n")[0].length();
        input = input.replace('\n', '_');
        var pattern = Pattern.compile("(?=M(.M.{" + (i - 2) + "}.A..{" + (i - 2) + "}S.S))|" +
                "(?=M(.S.{" + (i - 2) + "}.A..{" + (i - 2) + "}M.S))|" +
                "(?=S(.M.{" + (i - 2) + "}.A..{" + (i - 2) + "}S.M))|" +
                "(?=S(.S.{" + (i - 2) + "}.A..{" + (i - 2) + "}M.M))");
        long XMAS = 0;
        var matcher = pattern.matcher(input);
        while (matcher.find()) {
            XMAS++;
        }
        System.out.println(XMAS);
    }
}
