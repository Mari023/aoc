package year2023.day16;

import util.TimedTest;

import java.util.ArrayList;
import java.util.List;

public class Day16 {
    public static void main(String[] args) {
        var input = Input.INPUT;
        System.out.println(energize(input, 0, 0, Beam.Direction.East));

        if(!TimedTest.PRINT) return;//don't run part 2 in tests

        long energized = 0;
        for (int i = 0; i < input.length; i++) {
            energized = Math.max(energized, energize(input, 0, i, Beam.Direction.East));
            energized = Math.max(energized, energize(input, input[i].length() - 1, i, Beam.Direction.West));
        }
        for (int i = 0; i < input[0].length(); i++) {
            energized = Math.max(energized, energize(input, i, 0, Beam.Direction.South));
            energized = Math.max(energized, energize(input, i, input.length - 1, Beam.Direction.North));
        }
        System.out.println(energized);
    }

    private static long energize(String[] input, int startX, int startY, Beam.Direction startDirection) {
        int xBound = input[0].length();
        int yBound = input.length;
        boolean[][] energized = new boolean[yBound][xBound];
        int[][] passed = new int[yBound][xBound];
        List<Beam> beams = new ArrayList<>();
        beams.add(new Beam(startX, startY, startDirection));
        while (!beams.isEmpty()) {
            Beam beam = beams.getFirst();
            if (beam.outOfBounds(xBound, yBound)) {
                beams.remove(beam);
                continue;
            }
            if ((passed[beam.y][beam.x] & beam.direction.id) != 0) {
                beams.remove(beam);
                continue;
            }

            energized[beam.y][beam.x] = true;
            passed[beam.y][beam.x] += beam.direction.id;
            Beam newBeam = beam.move(input[beam.y].charAt(beam.x));
            if (newBeam != null) beams.add(newBeam);
        }

        long solution = 0;
        for (boolean[] e : energized) {
            for (boolean b : e) {
                if (b) solution++;
            }
        }
        if (TimedTest.PRINT) {
            printEnergized(energized);
            System.out.println(solution);
            System.out.println();
        }
        return solution;
    }

    private static void printEnergized(boolean[][] energized) {
        StringBuilder s = new StringBuilder();
        for (boolean[] e : energized) {
            for (boolean b : e) {
                if (b) {
                    s.append('#');
                } else {
                    s.append('.');
                }
            }
            s.append('\n');
        }
        System.out.print(s);
    }
}
