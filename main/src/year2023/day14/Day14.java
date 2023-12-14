package year2023.day14;

import util.TimedTest;
import util.Util;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Day14 {
    private static final Pattern NOTROCK = Pattern.compile("[#.]+");
    private static final int CYCLE_LENGTH = 2 * 2 * 3 * 3 * 5 * 5 * 7;
    private static final int TOTAL_CYCLES = 1000000000;

    public static void main(String[] args) {
        //TODO make the array 1D instead
        char[][] input = new char[Input.INPUT.length][];
        for (int i = 0; i < Input.INPUT.length; i++) {
            input[i] = Input.INPUT[i].toCharArray();
        }
        rollUp(input);

        if (TimedTest.PRINT) Util.printCharArrayArray(input);
        System.out.println(calculateNorthLoad(input));


        rollLeft(input);
        if (TimedTest.PRINT) {
            System.out.println();
            Util.printCharArrayArray(input);
        }
        rollDown(input);
        if (TimedTest.PRINT) {
            System.out.println();
            Util.printCharArrayArray(input);
        }
        rollRight(input);
        if (TimedTest.PRINT) {
            System.out.println();
            Util.printCharArrayArray(input);
            System.out.println();
        }
        for (int i = 0; i < TOTAL_CYCLES; i += CYCLE_LENGTH) {
            var copy = clone(input);
            int j = 0;
            for (; j < CYCLE_LENGTH && i + j < TOTAL_CYCLES; j++) {
                rollUp(input);
                rollLeft(input);
                rollDown(input);
                rollRight(input);
            }
            if (Arrays.deepEquals(input, copy)) break;
        }

        if (TimedTest.PRINT) Util.printCharArrayArray(input);
        System.out.println(calculateNorthLoad(input));
    }

    private static long calculateNorthLoad(char[][] rocks) {
        long load = 0;
        for (int i = 0; i < rocks.length; i++) {
            load += (long) NOTROCK.matcher(new String(rocks[i])).replaceAll("").length() * (rocks.length - i);
        }
        return load;
    }

    private static char[][] clone(char[][] rocks) {
        var clone = rocks.clone();
        for (int i = 0; i < clone.length; i++) {
            clone[i] = clone[i].clone();
        }
        return clone;
    }

    private static void rollUp(char[][] rocks) {
        for (int i = 1; i < rocks.length; i++) {
            for (int j = 0; j < rocks[i].length; j++) {
                int y = i;
                while (rollUp(rocks, j, y)) {
                    y--;
                }
            }
        }
    }

    private static boolean rollUp(char[][] rocks, int x, int y) {
        if (y == 0) return false;

        if (rocks[y][x] == 'O' && rocks[y - 1][x] == '.') {
            rocks[y][x] = '.';
            rocks[y - 1][x] = 'O';
            return true;
        }
        return false;
    }

    private static void rollDown(char[][] rocks) {
        for (int i = rocks.length - 2; i >= 0; i--) {
            for (int j = 0; j < rocks[i].length; j++) {
                int y = i;
                while (rollDown(rocks, j, y)) {
                    y++;
                }
            }
        }
    }

    private static boolean rollDown(char[][] rocks, int x, int y) {
        if (y == rocks.length - 1) return false;

        if (rocks[y][x] == 'O' && rocks[y + 1][x] == '.') {
            rocks[y][x] = '.';
            rocks[y + 1][x] = 'O';
            return true;
        }
        return false;
    }


    private static void rollLeft(char[][] rocks) {
        for (int j = 1; j < rocks[0].length; j++) {
            for (int i = 0; i < rocks.length; i++) {
                int x = j;
                while (rollLeft(rocks, x, i)) {
                    x--;
                }
            }
        }
    }


    private static boolean rollLeft(char[][] rocks, int x, int y) {
        if (x == 0) return false;

        if (rocks[y][x] == 'O' && rocks[y][x - 1] == '.') {
            rocks[y][x] = '.';
            rocks[y][x - 1] = 'O';
            return true;
        }
        return false;
    }


    private static void rollRight(char[][] rocks) {
        for (int j = rocks[0].length - 2; j >= 0; j--) {
            for (int i = 0; i < rocks.length; i++) {
                int x = j;
                while (rollRight(rocks, x, i)) {
                    x++;
                }
            }
        }
    }


    private static boolean rollRight(char[][] rocks, int x, int y) {
        if (x == rocks[y].length - 1) return false;

        if (rocks[y][x] == 'O' && rocks[y][x + 1] == '.') {
            rocks[y][x] = '.';
            rocks[y][x + 1] = 'O';
            return true;
        }
        return false;
    }
}
