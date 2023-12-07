package year2023.day01;

public class Day01_extra {
    public static void main(String[] args) {
        String rawInput = Input.INPUT;
        rawInput = rawInput.replaceAll("one", "o1e");
        rawInput = rawInput.replaceAll("two", "t2o");
        rawInput = rawInput.replaceAll("three", "t3e");
        rawInput = rawInput.replaceAll("four", "4");
        rawInput = rawInput.replaceAll("five", "5e");
        rawInput = rawInput.replaceAll("six", "6");
        rawInput = rawInput.replaceAll("seven", "7n");
        rawInput = rawInput.replaceAll("eight", "e8t");
        rawInput = rawInput.replaceAll("nine", "n9e");
        rawInput = rawInput.replaceAll("[a-z]+", "");
        String[] inputs = rawInput.split("\n");

        long result = 0;
        for (String input : inputs) {
            result += Long.parseLong(input.charAt(0) + "") * 10 + Long.parseLong(input.charAt(input.length() - 1) + "");
        }
        System.out.println(result);
    }
}
