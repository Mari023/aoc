package year2023.day14;

import util.CharArray2D;

import java.util.regex.Pattern;

public class RockField extends CharArray2D {
    private static final Pattern NOTROCK = Pattern.compile("[#.]+");

    public RockField(RockField array) {
        super(array);
    }

    public RockField(String[] strings) {
        super(strings);
    }

    public long calculateNorthLoad() {
        long load = 0;
        for (int i = 0; i < getRows(); i++) {
            load += (long) NOTROCK.matcher(new String(getRow(i))).replaceAll("").length() * (getRows() - i);
        }
        return load;
    }

    public void rollUp() {
        for (int i = 1; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                int y = i;
                while (rollUp(j, y)) {
                    y--;
                }
            }
        }
    }

    private boolean rollUp(int x, int y) {
        if (y == 0) return false;

        if (get(x, y) == 'O' && get(x, y - 1) == '.') {
            set(x, y, '.');
            set(x, y - 1, 'O');
            return true;
        }
        return false;
    }

    public void rollDown() {
        for (int i = getRows() - 2; i >= 0; i--) {
            for (int j = 0; j < getColumns(); j++) {
                int y = i;
                while (rollDown(j, y)) {
                    y++;
                }
            }
        }
    }

    private boolean rollDown(int x, int y) {
        if (y == getRows() - 1) return false;

        if (get(x, y) == 'O' && get(x, y + 1) == '.') {
            set(x, y, '.');
            set(x, y + 1, 'O');
            return true;
        }
        return false;
    }


    public void rollLeft() {
        for (int j = 1; j < getColumns(); j++) {
            for (int i = 0; i < getRows(); i++) {
                int x = j;
                while (rollLeft(x, i)) {
                    x--;
                }
            }
        }
    }


    private boolean rollLeft(int x, int y) {
        if (x == 0) return false;

        if (get(x, y) == 'O' && get(x - 1, y) == '.') {
            set(x, y, '.');
            set(x - 1, y, 'O');
            return true;
        }
        return false;
    }


    public void rollRight() {
        for (int j = getColumns() - 2; j >= 0; j--) {
            for (int i = 0; i < getRows(); i++) {
                int x = j;
                while (rollRight(x, i)) {
                    x++;
                }
            }
        }
    }


    private boolean rollRight(int x, int y) {
        if (x == getColumns() - 1) return false;

        if (get(x, y) == 'O' && get(x + 1, y) == '.') {
            set(x, y, '.');
            set(x + 1, y, 'O');
            return true;
        }
        return false;
    }
}
