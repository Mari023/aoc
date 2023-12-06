package util;

import year2023.day01.Day01;
import year2023.day01.Day01_extra;
import year2023.day02.Day02;
import year2023.day03.Day03;
import year2023.day04.Day04;
import year2023.day05.Day05;
import year2023.day06.Day06;

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
        Day01.main(null);
        Day01_extra.main(null);
        Day02.main(null);
        Day03.main(null);
        Day04.main(null);
        Day05.main(null);
        Day06.main(null);
    }
}
