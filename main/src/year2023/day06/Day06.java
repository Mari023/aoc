package year2023.day06;

public class Day06 {
    public static void main(String[] args) {
        String[] times = Input.INPUT[0].split(" +");
        String[] distances = Input.INPUT[1].split(" +");

        long solution = 1;
        for (int i = 0; i < times.length - 1; i++) {
            solution *= calculatePossibleSolutions(Integer.parseInt(times[i + 1]), Integer.parseInt(distances[i + 1]));
        }
        System.out.println(solution);

        long time = Long.parseLong(Input.INPUT[0].split(":")[1].replaceAll(" ", ""));
        long distance = Long.parseLong(Input.INPUT[1].split(":")[1].replaceAll(" ", ""));
        System.out.println(calculatePossibleSolutions(time, distance));
    }

    private static long calculatePossibleSolutions(long time, long distance) {
        double sqrt = Math.sqrt(Math.pow(time / 2d, 2) - distance);
        return (long) Math.ceil(time / 2d + sqrt) - 1 -
                ((long) Math.floor(time / 2d - sqrt) + 1) + 1;
    }

}
