package util;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TimedTest {
    public static void main(String[] args) {
        long[] times = new long[1000];
        for (int i = 0; i < times.length; i++) {
            long time = System.nanoTime();
            time();
            times[i] = System.nanoTime() - time;
        }
        System.out.println();
        System.out.println(TimeUnit.NANOSECONDS.toMicros(times[times.length - 1]));
        System.out.println(TimeUnit.NANOSECONDS.toMicros((long) Arrays.stream(times).average().orElseThrow()));
    }

    private static void time() {
        //put day to time here
    }
}
