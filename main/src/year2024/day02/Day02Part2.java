package year2024.day02;

import java.util.ArrayList;
import java.util.List;

import static year2024.day02.Day02.isSafe;

public class Day02Part2 {
    public static void main() {
        int safeLines = 0;
        List<String[]> unsafe = new ArrayList<>();
        for (String s : Input.INPUT.split("\n")) {
            var line = s.split(" ");
            if (isSafe(line)) safeLines++;
            else unsafe.add(line);
        }

        for (String[] line : unsafe) {
            List<Integer> report = new ArrayList<>();
            for (String s : line) {
                report.add(Integer.parseInt(s));
            }
            if (isSafeDampened(report)) safeLines++;
        }

        System.out.println(safeLines);
    }

    private static boolean isSafeDampened(List<Integer> report) {
        Day02.State state = Day02.State.UNKNOWN;
        for (int i = 1; i < report.size(); i++) {
            int current = report.get(i);
            int previous = report.get(i - 1);

            if (current == previous) {
                return check(report, i);
            }
            if (Math.abs(current - previous) > 3) {
                return check(report, i);
            }

            state = state.transition(current, previous);
            if (state == Day02.State.UNSAFE) {
                return check(report, i);
            }
        }
        return true;
    }

    private static boolean check(List<Integer> report, int position) {
        var a = new ArrayList<>(report);
        var b = new ArrayList<>(report);
        var c = new ArrayList<>(report);
        var d = new ArrayList<>(report);
        if (position > 1) d.remove(position - 2);
        a.remove(position - 1);
        b.remove(position);
        if (c.size() > position + 1) c.remove(position + 1);

        boolean safe = isSafeAfterDampening(d) || isSafeAfterDampening(a) || isSafeAfterDampening(b) || isSafeAfterDampening(c);
        if (!safe) {
            System.out.println(report);
            System.out.println(d);
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println();
        }
        return safe;
    }

    private static boolean isSafeAfterDampening(List<Integer> report) {
        Day02.State state = Day02.State.UNKNOWN;
        for (int i = 1; i < report.size(); i++) {
            int current = report.get(i);
            int previous = report.get(i - 1);

            if (current == previous) return false;
            if (Math.abs(current - previous) > 3) return false;

            state = state.transition(current, previous);
            if (state == Day02.State.UNSAFE) return false;
        }
        return true;
    }
}
