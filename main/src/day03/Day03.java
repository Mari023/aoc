package day03;

import util.MutableLong;
import util.Util;

public class Day03 {
    public static void main(String[] args) {
        final MutableLong solution = new MutableLong();
        Util.loopSC(Input.INPUT, (String input, char ch, int i, int j) -> {
            if (isPart(ch)) {
                int a = getNumber(Input.INPUT, i - 1, j - 1);
                int b = getNumber(Input.INPUT, i - 1, j);
                int c = getNumber(Input.INPUT, i - 1, j + 1);

                if (b != 0) {
                    solution.add(b);
                } else {
                    solution.add(a + c);
                }

                solution.add(getNumber(Input.INPUT, i, j - 1));
                solution.add(getNumber(Input.INPUT, i, j + 1));

                a = getNumber(Input.INPUT, i + 1, j - 1);
                b = getNumber(Input.INPUT, i + 1, j);
                c = getNumber(Input.INPUT, i + 1, j + 1);

                if (b != 0) {
                    solution.add(b);
                } else {
                    solution.add(a + c);
                }
            }
        });

        System.out.println(solution);

        solution.set(0);
        Util.loopSC(Input.INPUT, (String input, char ch, int i, int j) -> {
            if (ch == '*') {
                int gearRatio = 1;
                int numberCount = 0;
                int a = getNumber(Input.INPUT, i - 1, j - 1);
                int b = getNumber(Input.INPUT, i - 1, j);
                int c = getNumber(Input.INPUT, i - 1, j + 1);

                if (b != 0) {
                    gearRatio *= b;
                    numberCount++;
                } else {
                    if (a != 0) {
                        gearRatio *= a;
                        numberCount++;
                    }
                    if (c != 0) {
                        gearRatio *= c;
                        numberCount++;
                    }
                }

                int d = getNumber(Input.INPUT, i, j - 1);
                if (d != 0) {
                    gearRatio *= d;
                    numberCount++;
                }
                d = getNumber(Input.INPUT, i, j + 1);
                if (d != 0) {
                    gearRatio *= d;
                    numberCount++;
                }

                a = getNumber(Input.INPUT, i + 1, j - 1);
                b = getNumber(Input.INPUT, i + 1, j);
                c = getNumber(Input.INPUT, i + 1, j + 1);


                if (b != 0) {
                    gearRatio *= b;
                    numberCount++;
                } else {
                    if (a != 0) {
                        gearRatio *= a;
                        numberCount++;
                    }
                    if (c != 0) {
                        gearRatio *= c;
                        numberCount++;
                    }
                }

                if (numberCount >= 2) solution.add(gearRatio);
            }
        });

        System.out.println(solution);
    }

    public static int getNumber(String[] input, int lineN, int character) {
        if (lineN < 0 || character < 0) {
            return 0;
        }
        if (input.length <= lineN) {
            return 0;
        }
        String line = input[lineN];
        if (line.length() <= character) {
            return 0;
        }

        if (isDigit(line, character)) {
            int leftBound = character;
            int rightBound = character;
            while (isDigit(line, leftBound - 1)) {
                leftBound -= 1;
            }
            while (isDigit(line, rightBound + 1)) {
                rightBound += 1;
            }

            return Integer.parseInt(line.substring(leftBound, rightBound + 1));
        }
        return 0;
    }

    public static boolean isPart(char c) {
        return c != '.' && !Character.isAlphabetic(c) && !Character.isDigit(c);
    }

    public static boolean isDigit(String s, int i) {
        if (i < 0 || i >= s.length()) return false;
        return Character.isDigit(s.charAt(i));
    }
}
