package year2024.day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 {
    public static void main() {
        var input = readInput();
        var listA = input.listA();
        var listB = input.listB();
        Collections.sort(listA);
        Collections.sort(listB);
        long result = 0;
        for (int i = 0; i < listA.size(); i++) {
            result += Math.abs(listA.get(i) - listB.get(i));
        }
        System.out.println(result);
    }

    public static Pair readInput() {
        String[] input = Input.INPUT.split(" {3}|\n");
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < input.length - 1; i += 2) {
            listA.add(Integer.parseInt(input[i]));
            listB.add(Integer.parseInt(input[i + 1]));
        }
        if (listA.size() != listB.size()) {
            System.err.println("List sizes don't match");
            System.exit(1);
        }
        return new Pair(listA, listB);
    }

    public record Pair(List<Integer> listA, List<Integer> listB) {}
}
