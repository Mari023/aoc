package year2023.day09;

import java.util.ArrayList;
import java.util.List;

public class Day09 {
    public static void main(String[] args) {
        List<List<Long>> data = new ArrayList<>();

        for (String s : Input.INPUT) {
            List<Long> dataset = new ArrayList<>();
            data.add(dataset);

            for (String value : s.split(" ")) {
                dataset.add(Long.parseLong(value));
            }
        }

        long result1 = 0;
        long result2 = 0;
        for (List<Long> datum : data) {
            long[] prediction = getNext(datum);
            result1 += prediction[0];
            result2 += prediction[1];
        }
        System.out.println(result1);
        System.out.println(result2);
    }

    private static long[] getNext(List<Long> list) {
        List<List<Long>> data = new ArrayList<>();
        data.add(list);
        while (!isAllSame(data.getLast())) {
            data.add(getDerivative(data.getLast()));
        }
        long[] prediction = new long[2];
        for (int i = data.size() - 1; i >= 0; i--) {
            var derivative = data.get(i);
            prediction[0] += derivative.getLast();
            prediction[1] = derivative.getFirst() - prediction[1];
        }
        return prediction;
    }

    private static List<Long> getDerivative(List<Long> list) {
        List<Long> derivative = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            derivative.add(list.get(i + 1) - list.get(i));
        }
        return derivative;
    }

    private static boolean isAllSame(List<Long> list) {
        long i = list.getFirst();
        for (Long j : list) {
            if (i != j) return false;
        }
        return true;
    }
}
