package year2023.day01;

public class Day01 {
    public static void main(String[] args) {
        String[] inputs = Input.INPUT.replaceAll("[a-z]+", "").split("\n");
        long result = 0;
        for (String input : inputs) {
            result += Long.parseLong(input.charAt(0) + "") * 10 + Long.parseLong(input.charAt(input.length() - 1) + "");
        }
        System.out.println(result);
    }
}
