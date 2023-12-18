package year2023.day18;


import util.TimedTest;
import util.Util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Day18 {
    public static void main(String[] args) {
        String[] input = Input.INPUT;
        List<Node> ground = new ArrayList<>();
        int x = 0, y = 0;
        for (String operation : input) {
            Operation o = Operation.of(operation);
            for (int i = 0; i < o.length(); i++) {
                switch (o.direction()) {
                    case U -> y--;
                    case D -> y++;
                    case L -> x--;
                    case R -> x++;
                }
                ground.add(new Node(x, y, o.color()));
            }
        }

        int minX = 0, minY = 0, maxX = 0, maxY = 0;
        for (Node n : ground) {
            minX = Math.min(minX, n.x());
            minY = Math.min(minY, n.y());
            maxX = Math.max(maxX, n.x());
            maxY = Math.max(maxY, n.y());
        }
        char[][] dug = new char[maxY - minY + 1][maxX - minX + 1];
        for (Node n : ground) {
            dug[n.y() - minY][n.x() - minX] = '□';
        }

        var queue = new ArrayDeque<Position>();
        for (int i = 0; i < dug.length; i++) {
            queue.add(new Position(0, i));
            queue.add(new Position(dug[i].length - 1, i));
        }
        for (int i = 0; i < dug[0].length; i++) {
            queue.add(new Position(i, 0));
            queue.add(new Position(i, dug.length - 1));
        }

        while (!queue.isEmpty()) {
            Position p = queue.pop();
            if (p.outOfBounds(dug[0].length, dug.length)) continue;
            if (dug[p.y()][p.x()] != '\0') continue;
            dug[p.y()][p.x()] = '■';
            queue.add(p.right());
            queue.add(p.down());
            queue.add(p.left());
            queue.add(p.up());
        }

        int solution = 0;
        for (int i = 0; i < dug.length; i++) {
            for (int j = 0; j < dug[i].length; j++) {
                if (dug[i][j] != '■') {
                    solution++;
                    dug[i][j] = '□';
                }
            }
        }

        if (TimedTest.PRINT) Util.printCharArrayArray(dug);
        System.out.println(solution);
    }
}
