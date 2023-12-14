package year2023.day14;

import util.TimedTest;

import java.util.regex.Pattern;

public class Day14 {
    private static final Pattern NOTROCK = Pattern.compile("[#.]+");
    private static final int CYCLE_LENGTH = 2 * 2 * 3 * 3 * 5 * 5 * 7;
    private static final int TOTAL_CYCLES = 1000000000;

    public static void main(String[] args) {
        var rocks = new RockField(Input.INPUT);
        rollUp(rocks);

        if (TimedTest.PRINT) System.out.println(rocks);
        System.out.println(calculateNorthLoad(rocks));


        rollLeft(rocks);
        if (TimedTest.PRINT) {
            System.out.println();
            System.out.println(rocks);
        }
        rollDown(rocks);
        if (TimedTest.PRINT) {
            System.out.println();
            System.out.println(rocks);
        }
        rollRight(rocks);
        if (TimedTest.PRINT) {
            System.out.println();
            System.out.println(rocks);
            System.out.println();
        }
        for (int i = 0; i < TOTAL_CYCLES; i += CYCLE_LENGTH) {
            var copy = new RockField(rocks);
            int j = 0;
            for (; j < CYCLE_LENGTH && i + j < TOTAL_CYCLES; j++) {
                rollUp(rocks);
                rollLeft(rocks);
                rollDown(rocks);
                rollRight(rocks);
            }
            if (rocks.equals(copy)) break;
        }

        if (TimedTest.PRINT) System.out.println(rocks);
        System.out.println(calculateNorthLoad(rocks));
    }

    private static long calculateNorthLoad(RockField rocks) {
        long load = 0;
        for (int i = 0; i < rocks.getRows(); i++) {
            load += (long) NOTROCK.matcher(new String(rocks.getRow(i))).replaceAll("").length() * (rocks.getRows() - i);
        }
        return load;
    }

    private static void rollUp(RockField rocks) {
        for (int i = 1; i < rocks.getRows(); i++) {
            for (int j = 0; j < rocks.getColumns(); j++) {
                int y = i;
                while (rollUp(rocks, j, y)) {
                    y--;
                }
            }
        }
    }

    private static boolean rollUp(RockField rocks, int x, int y) {
        if (y == 0) return false;

        if (rocks.get(x, y) == 'O' && rocks.get(x, y - 1) == '.') {
            rocks.set(x, y, '.');
            rocks.set(x, y - 1, 'O');
            return true;
        }
        return false;
    }

    private static void rollDown(RockField rocks) {
        for (int i = rocks.getRows() - 2; i >= 0; i--) {
            for (int j = 0; j < rocks.getColumns(); j++) {
                int y = i;
                while (rollDown(rocks, j, y)) {
                    y++;
                }
            }
        }
    }

    private static boolean rollDown(RockField rocks, int x, int y) {
        if (y == rocks.getRows() - 1) return false;

        if (rocks.get(x, y) == 'O' && rocks.get(x, y + 1) == '.') {
            rocks.set(x, y, '.');
            rocks.set(x, y + 1, 'O');
            return true;
        }
        return false;
    }


    private static void rollLeft(RockField rocks) {
        for (int j = 1; j < rocks.getColumns(); j++) {
            for (int i = 0; i < rocks.getRows(); i++) {
                int x = j;
                while (rollLeft(rocks, x, i)) {
                    x--;
                }
            }
        }
    }


    private static boolean rollLeft(RockField rocks, int x, int y) {
        if (x == 0) return false;

        if (rocks.get(x, y) == 'O' && rocks.get(x - 1, y) == '.') {
            rocks.set(x, y, '.');
            rocks.set(x - 1, y, 'O');
            return true;
        }
        return false;
    }


    private static void rollRight(RockField rocks) {
        for (int j = rocks.getColumns() - 2; j >= 0; j--) {
            for (int i = 0; i < rocks.getRows(); i++) {
                int x = j;
                while (rollRight(rocks, x, i)) {
                    x++;
                }
            }
        }
    }


    private static boolean rollRight(RockField rocks, int x, int y) {
        if (x == rocks.getColumns() - 1) return false;

        if (rocks.get(x, y) == 'O' && rocks.get(x + 1, y) == '.') {
            rocks.set(x, y, '.');
            rocks.set(x + 1, y, 'O');
            return true;
        }
        return false;
    }
}
