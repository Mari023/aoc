package year2023.day14;

import util.TimedTest;

public class Day14 {
    private static final int CYCLE_LENGTH = 2 * 2 * 3 * 3 * 5 * 5 * 7 * 11;
    private static final int TOTAL_CYCLES = 1000000000;

    public static void main(String[] args) {
        var rocks = new RockField(Input.INPUT);
        rocks.rollUp();

        if (TimedTest.PRINT) System.out.println(rocks);
        System.out.println(rocks.calculateNorthLoad());


        rocks.rollLeft();
        if (TimedTest.PRINT) {
            System.out.println(rocks);
        }
        rocks.rollDown();
        if (TimedTest.PRINT) {
            System.out.println(rocks);
        }
        rocks.rollRight();
        if (TimedTest.PRINT) {
            System.out.println(rocks);
            System.out.println();
        }
        for (int i = 0; i < TOTAL_CYCLES; i += CYCLE_LENGTH) {
            var copy = new RockField(rocks);
            int j = 0;
            for (; j < CYCLE_LENGTH && i + j < TOTAL_CYCLES; j++) {
                rocks.rollUp();
                rocks.rollLeft();
                rocks.rollDown();
                rocks.rollRight();
            }
            if (rocks.equals(copy)) break;
        }

        if (TimedTest.PRINT) System.out.println(rocks);
        System.out.println(rocks.calculateNorthLoad());
    }
}
