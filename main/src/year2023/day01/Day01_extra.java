package year2023.day01;

public class Day01_extra {
    public static void main(String[] args) {
        long result = 0;
        for (String input : Input.INPUT) {
            input = input.replaceAll("one", "one1one");
            input = input.replaceAll("two", "two2two");
            input = input.replaceAll("three", "three3three");
            input = input.replaceAll("four", "four4four");
            input = input.replaceAll("five", "five5five");
            input = input.replaceAll("six", "six6six");
            input = input.replaceAll("seven", "seven7seven");
            input = input.replaceAll("eight", "eight8eight");
            input = input.replaceAll("nine", "nine9nine");

            input = input.replaceAll("[a-z]", "");
            result += Long.parseLong(input.charAt(0) + "") * 10 + Long.parseLong(input.charAt(input.length() - 1) + "");
        }
        System.out.println(result);
    }
}
