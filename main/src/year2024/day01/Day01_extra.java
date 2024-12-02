package year2024.day01;

import java.util.Collections;

public class Day01_extra {
    public static void main() {
        var input = Day01.readInput();
        var listA = input.listA();
        var listB = input.listB();
        Collections.sort(listA);
        int max = Math.max(Collections.max(listB), listA.getLast());
        var occurrenceB = new int[max + 1];
        for (int i : listB) {
            occurrenceB[i]++;
        }

        long result = 0;
        for (int i : listA) {
            result += (long) i * occurrenceB[i];
        }
        System.out.println(result);
    }
}
