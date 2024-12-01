package year2023.day12;

public class Day12 {
    public static final boolean DAY12_PART2_DISABLED = true;
    public static void main(String[] args) {
        long result = 0;
        for (String s : Input.INPUT) {
            var input = s.split(" ");
            var groupStrings = input[1].split(",");
            int[] groups = new int[groupStrings.length];
            for (int i = 0; i < groupStrings.length; i++) {
                groups[i] = Integer.parseInt(groupStrings[i]);
            }

            result += getSolutions(input[0], groups);
        }

        System.out.println(result);
        if(DAY12_PART2_DISABLED) return;

        result = 0;
        for (String s : Input.INPUT) {
            var input = s.split(" ");
            var groupStrings = input[1].split(",");
            int[] groups = new int[groupStrings.length * 5];
            for (int i = 0; i < groupStrings.length; i++) {
                groups[i] = Integer.parseInt(groupStrings[i]);
                groups[i + groupStrings.length] = groups[i];
                groups[i + groupStrings.length * 2] = groups[i];
                groups[i + groupStrings.length * 3] = groups[i];
            }
            input[0] = input[0] + "?" + input[0] + "?" + input[0] + "?" + input[0] + "?";
            result += getSolutions(input[0], groups);
        }
        System.out.println(result);
    }

    private static long getSolutions(String springs, int[] groups) {
        int unknown = springs.replaceAll("[.#]+", "").length();

        long solutions = 0;
        long bound = (long) Math.pow(2, unknown);
        var springArray = springs.toCharArray();

        for (long i = 0; i < bound; i++) {
            if (isSolution(springArray, groups, i)) solutions++;

        }
        return solutions;
    }

    private static boolean isSolution(char[] springs, int[] groups, long id) {
        int runLength = 0;
        int group = 0;
        int unknown = 0;
        for (char c : springs) {
            if (c == '?') {
                c = ((id >>> unknown) & 1) == 0 ? '#' : '.';
                unknown++;
            }
            if (c == '#') {
                runLength++;
            } else if (c == '.') {
                if (runLength != 0) {
                    if (group >= groups.length || groups[group] != runLength) return false;
                    runLength = 0;
                    group++;
                }
            }
        }
        if (runLength != 0) {
            if (group >= groups.length || groups[group] != runLength) return false;
            group++;
        }
        return group == groups.length;
    }
}
