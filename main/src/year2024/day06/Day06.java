package year2024.day06;

import util.CharArray2D;

public class Day06 {
    public static void main() {
        var map = new CharArray2D(Input.INPUT.split("\n"));
        int x = -1;
        int y = -1;
        Direction direction = Direction.NORTH;
        for (int i = 0; i < map.array().length; i++) {
            if (map.array()[i] == '^') {
                x = map.getColumnIndex(i);
                y = map.getRowIndex(i);
            }
        }

        while (map.isInside(x, y)) {
            char next = getAhead(map, direction, x, y);
            if (next == '.' || next == 'X') {
                map.set(x, y, 'X');
                switch (direction) {
                    case NORTH -> y--;
                    case EAST -> x++;
                    case SOUTH -> y++;
                    case WEST -> x--;
                }
            } else if (next == '#') {
                direction = switch (direction) {
                    case NORTH -> Direction.EAST;
                    case EAST -> Direction.SOUTH;
                    case SOUTH -> Direction.WEST;
                    case WEST -> Direction.NORTH;
                };
            }
        }

        int result = 0;
        for (char c : map.array()) {
            if (c == 'X') result++;
        }
        System.out.println(result);
    }

    private static char getAhead(CharArray2D map, Direction direction, int x, int y) {
        return switch (direction) {
            case NORTH -> map.getOrElse(x, y - 1, '.');
            case EAST -> map.getOrElse(x + 1, y, '.');
            case SOUTH -> map.getOrElse(x, y + 1, '.');
            case WEST -> map.getOrElse(x - 1, y, '.');
        };
    }
}
