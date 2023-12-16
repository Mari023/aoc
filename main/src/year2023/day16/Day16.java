package year2023.day16;

import java.util.ArrayList;
import java.util.List;

public class Day16 {
    public static void main(String[] args) {
        var input = Input.INPUT;
        int xBound = input[0].length();
        int yBound = input.length;
        boolean[][] energized = new boolean[yBound][xBound];
        int[][] passed = new int[yBound][xBound];
        List<Beam> beams = new ArrayList<>();
        beams.add(new Beam());
        while (!beams.isEmpty()) {
            Beam beam = beams.get(0);
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
        System.out.println(solution);
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
        System.out.println(s);
    }
}
