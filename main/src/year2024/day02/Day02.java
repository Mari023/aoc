package year2024.day02;

public class Day02 {
    public static void main() {
        int safeLines = 0;
        for (String s : Input.INPUT.split("\n")) {
            if(isSafe(s.split(" "))) safeLines++;
        }
        System.out.println(safeLines);
    }

    public static boolean isSafe(String[] line) {
        State state = State.UNKNOWN;
        for (int i = 1; i < line.length; i++) {
            int current = Integer.parseInt(line[i]);
            int previous = Integer.parseInt(line[i - 1]);

            if(current == previous) return false;
            if(Math.abs(current - previous) > 3) return false;

            state = state.transition(current, previous);
            if(state == State.UNSAFE) return false;
        }
        return true;
    }

    public enum State {
        UNKNOWN, INCREASING, DECREASING, UNSAFE;

        State transition(int current, int previous) {
            return switch (this) {
                case UNKNOWN -> current > previous ? INCREASING : DECREASING;
                case INCREASING -> current > previous ? INCREASING : UNSAFE;
                case DECREASING -> current < previous ? DECREASING : UNSAFE;
                case UNSAFE -> UNSAFE;
            };
        }
    }
}
