package year2023.day13;

public class Day13 {
    public static void main(String[] args) {
        long solution = 0;
        for (String s : Input.INPUT) {
            solution += getMirrored(s);
        }
        System.out.println(solution);
    }

    private static int getMirrored(String rocks) {
        String[] rows = rocks.split("\n");
        int mirroredRows = 0;
        for (int i = 0; i < rows.length - 1; i++) {
            if (rows[i].equals(rows[i + 1])) {
                boolean rowsEqual = true;
                for (int j = 1; j <= i && j + i + 1 < rows.length; j++) {
                    if (!rows[i - j].equals(rows[i + j + 1])) {
                        rowsEqual = false;
                        break;
                    }
                }
                if (rowsEqual) {
                    mirroredRows = i + 1;
                    break;
                }
            }
        }

        int mirroredColumns = 0;
        for (int i = 0; i < rows[0].length() - 1; i++) {
            boolean columnsEqual = true;
            for (String row : rows) {
                if (row.charAt(i) != row.charAt(i + 1)) {
                    columnsEqual = false;
                    break;
                }
            }
            if (columnsEqual) {
                for (int j = 1; j <= i && j + i + 1 < rows[0].length(); j++) {
                    for (String row : rows) {
                        if (row.charAt(i - j) != row.charAt(i + j + 1)) {
                            columnsEqual = false;
                            break;
                        }
                    }
                }

                if (columnsEqual) {
                    mirroredColumns = i + 1;
                    break;
                }
            }
        }

        return mirroredColumns + 100 * mirroredRows;
    }
}
