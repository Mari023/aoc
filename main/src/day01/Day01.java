package day01;

public class Day01 {
    public static void main(String[] args) {
        long result = 0;
        for (String input : Input.INPUT) {
            input = input.replaceAll("[a-z]", "");
            result += Long.parseLong(input.charAt(0) + "") * 10 + Long.parseLong(input.charAt(input.length() - 1) + "");
        }
        System.out.println(result);
    }
}
