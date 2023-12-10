package util;

import year2023.day01.Day01;
import year2023.day01.Day01_extra;
import year2023.day02.Day02;
import year2023.day03.Day03;
import year2023.day04.Day04;
import year2023.day05.Day05;
import year2023.day06.Day06;
import year2023.day07.Day07;
import year2023.day07.part2.Day07Part2;
import year2023.day08.Day08;
import year2023.day09.Day09;
import year2023.day10.Day10;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TimedTest {
    public static boolean PRINT = true;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        PRINT = false;
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

    private static void time() throws ExecutionException, InterruptedException {
        //put day to time here
        Day01.main(null);
        Day01_extra.main(null);
        Day02.main(null);
        Day03.main(null);
        Day04.main(null);
        Day05.main(null);
        Day06.main(null);
        Day07.main(null);
        Day07Part2.main(null);
        Day08.main(null);
        Day09.main(null);
        Day10.main(null);
    }
}
