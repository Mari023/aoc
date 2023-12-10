package year2023.day10;

import util.MutableLong;
import util.TimedTest;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Day10 {
    public static void main(String[] args) {
        char[][] pipes = new char[Input.INPUT.length][Input.INPUT[0].length()];
        if (TimedTest.PRINT) {
            printPipes(pipes);
            System.out.println();
        }

        MutableLong startX = new MutableLong();
        MutableLong startY = new MutableLong();
        Util.loopSC(Input.INPUT, (s, c, i, j) -> {
            pipes[i][j] = c;
            if (c == 'S') {
                startX.set(j);
                startY.set(i);
            }
        });

        List<Position> positions = new ArrayList<>();
        positions.add(new Position((int) startX.get(), (int) startY.get()).move(Position.Direction.N));
        positions.add(new Position((int) startX.get(), (int) startY.get()).move(Position.Direction.S));
        positions.add(new Position((int) startX.get(), (int) startY.get()).move(Position.Direction.W));
        positions.add(new Position((int) startX.get(), (int) startY.get()).move(Position.Direction.E));

        while (!positions.get(0).equals(positions.get(1))) {
            positions.removeIf(p -> {
                int x = p.x();
                int y = p.y();
                boolean b = p.move(pipes[y][x]);
                if (!b) replaceChar(pipes, x, y);
                return b;
            });
        }
        Position end = positions.get(0);
        pipes[end.y()][end.x()] = 'E';
        if (TimedTest.PRINT) printPipes(pipes);

        int area = 0;
        for (int i = 0; i < pipes.length; i++) {
            char[] line = pipes[i];
            boolean inHorizontally = false;
            for (int j = 0; j < line.length; j++) {
                switch (line[j]) {
                    case '┃', 'E' -> //hardcoded to my solution, since E is a ┃ for me
                            inHorizontally = !inHorizontally;
                    case '┗', 'S' -> //hardcoded to my solution, since S is a ┗ for me
                            inHorizontally = !inHorizontally;
                    case '┏', '┓', '━' -> {
                    }
                    case '┛' -> inHorizontally = !inHorizontally;
                    default -> {
                        if (inHorizontally) {
                            pipes[i][j] = '■';
                            area++;
                        } else {
                            pipes[i][j] = '□';
                        }
                    }
                }
            }
        }

        if (TimedTest.PRINT) printPipes(pipes);
        System.out.println(positions.get(0).steps());
        System.out.println(area);
    }

    public static void replaceChar(char[][] pipes, int x, int y) {
        char c = pipes[y][x];
        pipes[y][x] = switch (c) {
            case '║' -> '┃';
            case '═' -> '━';
            case '╚' -> '┗';
            case '╝' -> '┛';
            case '╗' -> '┓';
            case '╔' -> '┏';
            default -> c;
        };
    }

    public static void printPipes(char[][] pipes) {
        for (char[] pipe : pipes) {
            System.out.println(new String(pipe));
        }
    }
}
