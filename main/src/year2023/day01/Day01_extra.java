package year2023.day01;

public class Day01_extra {
    public static void main(String[] args) {
        String rawInput = Input.INPUT;
        rawInput = rawInput.replaceAll("one", "one1one");
        rawInput = rawInput.replaceAll("two", "two2two");
        rawInput = rawInput.replaceAll("three", "three3three");
        rawInput = rawInput.replaceAll("four", "four4four");
        rawInput = rawInput.replaceAll("five", "five5five");
        rawInput = rawInput.replaceAll("six", "six6six");
        rawInput = rawInput.replaceAll("seven", "seven7seven");
        rawInput = rawInput.replaceAll("eight", "eight8eight");
        rawInput = rawInput.replaceAll("nine", "nine9nine");
        rawInput = rawInput.replaceAll("[a-z]+", "");
        String[] inputs = rawInput.split("\n");

        long result = 0;
        for (String input : inputs) {
            result += Long.parseLong(input.charAt(0) + "") * 10 + Long.parseLong(input.charAt(input.length() - 1) + "");
        }
        System.out.println(result);
    }
}
