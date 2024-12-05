package year2024.day04;

import java.util.regex.Pattern;

public class Day04Part2 {
    public static void main() {
        String input = Input.INPUT;
        int i = input.split("\n")[0].length();
        input = input.replace('\n', '_');
        Pattern[] patterns = new Pattern[4];
        patterns[0] = Pattern.compile("(?=M(.M.{" + (i - 2) + "}.A..{" + (i - 2) + "}S.S))");
        patterns[1] = Pattern.compile("(?=M(.S.{" + (i - 2) + "}.A..{" + (i - 2) + "}M.S))");
        patterns[2] = Pattern.compile("(?=S(.M.{" + (i - 2) + "}.A..{" + (i - 2) + "}S.M))");
        patterns[3] = Pattern.compile("(?=S(.S.{" + (i - 2) + "}.A..{" + (i - 2) + "}M.M))");
        long XMAS = 0;
        for (Pattern pattern : patterns) {
            var matcher = pattern.matcher(input);
            while (matcher.find()) {
                XMAS++;
            }
        }
        System.out.println(XMAS);
    }
}
