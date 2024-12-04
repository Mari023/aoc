package year2024.day04;

import util.CharArray2D;

public class Day04 {
    public static void main() {
        var grid = new CharArray2D(Input.INPUT.split("\n"));
        Matcher matcher = new Matcher();
        loopHorizontal(grid, matcher);
        loopVertical(grid, matcher);
        loopSEDiagonal(grid, matcher);
        loopSWDiagonal(grid, matcher);
        System.out.println(matcher.matches());
    }

    private static void loopHorizontal(CharArray2D grid, Matcher m) {
        for (int x = 0; x < grid.getRows(); x++) {
            m.newLine();
            for (int y = 0; y < grid.getColumns(); y++) {
                m.consume(grid.get(x, y));
            }
        }
    }

    private static void loopVertical(CharArray2D grid, Matcher m) {
        for (int y = 0; y < grid.getColumns(); y++) {
            m.newLine();
            for (int x = 0; x < grid.getRows(); x++) {
                m.consume(grid.get(x, y));
            }
        }
    }

    private static void loopSEDiagonal(CharArray2D grid, Matcher m) {
        int diagonalCount = diagonalCount(grid);
        for (int i = 0; i < diagonalCount; i++) {
            int diagonalLength = diagonalLength(i, diagonalCount);
            m.newLine();
            for (int j = 0; j < diagonalLength; j++) {
                int x = grid.getColumns() - 1 - (Math.min(i, grid.getColumns() - 1) - j);
                int y = j + Math.max(0, i - (diagonalCount / 2));
                m.consume(grid.get(x, y));
            }
        }
    }

    private static void loopSWDiagonal(CharArray2D grid, Matcher m) {
        int diagonalCount = diagonalCount(grid);
        for (int i = 0; i < diagonalCount; i++) {
            int diagonalLength = diagonalLength(i, diagonalCount);
            m.newLine();
            for (int j = 0; j < diagonalLength; j++) {
                int x = Math.min(i, grid.getColumns() - 1) - j;
                int y = j + Math.max(0, i - (diagonalCount / 2));
                m.consume(grid.get(x, y));
            }
        }
    }

    private static int diagonalCount(CharArray2D grid) {
        return grid.getColumns() + grid.getRows() - 1;
    }

    /**
     * Calculate the length of a diagonal.
     * This formula only works for the diagonals of a square, but it turns out we need it for a square anyway.
     *
     * @param diagonal      the diagonal
     * @param diagonalCount how many diagonals there are
     * @return the length of that diagonal
     */
    private static int diagonalLength(int diagonal, int diagonalCount) {
        return diagonal <= diagonalCount / 2 ? diagonal + 1 : diagonalCount - diagonal;
    }
}
