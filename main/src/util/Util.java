package util;

public class Util {
    public static long clamp(long min, long value, long max) {
        return Math.min(Math.max(min, value), max);
    }

    public static void printCharArrayArray(char[][] chars) {
        for (char[] c : chars) {
            System.out.println(new String(c));
        }
    }

    public static void loopS(String[] input, SiConsumer consumer) {
        for (int i = 0; i < input.length; i++) {
            consumer.accept(input[i], i);
        }
    }

    public static void loopC(String input, ciConsumer consumer) {
        for (int i = 0; i < input.length(); i++) {
            consumer.accept(input.charAt(i), i);
        }
    }

    public static void loopSC(String[] input, sciiConsumer consumer) {
        loopS(input, (String s, int i) -> loopC(s, (char c, int j) -> consumer.accept(s, c, i, j)));
    }

    @FunctionalInterface
    public interface SiConsumer {
        void accept(String s, int i);
    }

    @FunctionalInterface
    public interface ciConsumer {
        void accept(char c, int i);
    }

    @FunctionalInterface
    public interface sciiConsumer {
        void accept(String s, char c, int i, int j);
    }
}
