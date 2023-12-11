package year2023.day11;

import java.util.ArrayList;
import java.util.List;

public class Day11 {
    public static void main(String[] args) {
        int[] emptySpaceHorizontal = new int[Input.INPUT[0].length()];
        int currentEmptySpace = 0;
        for (int i = 0; i < Input.INPUT[0].length(); i++) {
            boolean isEmpty = true;
            for (String string : Input.INPUT) {
                if (string.charAt(i) != '.') {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                currentEmptySpace++;
            }
            emptySpaceHorizontal[i] = currentEmptySpace;
        }

        int[] emptySpaceVertical = new int[Input.INPUT.length];
        currentEmptySpace = 0;
        String emptySpace = ".".repeat(Input.INPUT[0].length());
        for (int i = 0; i < Input.INPUT.length; i++) {
            if (Input.INPUT[i].equals(emptySpace)) {
                currentEmptySpace++;
            }
            emptySpaceVertical[i] = currentEmptySpace;
        }

        System.out.println(distance(galaxies(emptySpaceHorizontal, emptySpaceVertical, 2)));
        System.out.println(distance(galaxies(emptySpaceHorizontal, emptySpaceVertical, 1000000)));
    }

    private static List<Galaxy> galaxies(int[] emptySpaceHorizontal, int[] emptySpaceVertical, int expansionFactor) {
        List<Galaxy> galaxies = new ArrayList<>();
        for (int i = 0; i < Input.INPUT.length; i++) {
            String s = Input.INPUT[i];
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '#')
                    galaxies.add(new Galaxy(j + emptySpaceHorizontal[j] * (expansionFactor - 1), i + emptySpaceVertical[i] * (expansionFactor - 1)));
            }
        }
        return galaxies;
    }

    private static long distance(List<Galaxy> galaxies) {
        long result = 0;
        for (int i = 0; i < galaxies.size(); i++) {
            for (int j = i + 1; j < galaxies.size(); j++) {
                result += galaxies.get(i).distance(galaxies.get(j));
            }
        }
        return result;
    }
}
