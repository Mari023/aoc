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

        long result = 0;
        for (List<Long> datum : data) {
            result += getNext(datum);
        }
        System.out.println(result);
    }

    private static long getNext(List<Long> list) {
        List<List<Long>> data = new ArrayList<>();
        data.add(list);
        while (!isAllSame(data.get(data.size() - 1))) {
            data.add(getDerivative(data.get(data.size() - 1)));
        }
        long prediction = 0;
        for (int i = data.size() - 1; i > 0; i--) {
            var derivative = data.get(i);
            prediction += derivative.get(derivative.size() - 1);
        }
        printList(data);
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
        long i = list.get(0);
        for (Long j : list) {
            if (i != j) return false;
        }
        return true;
    }

    private static void printList(List<List<Long>> list) {
        for (var l : list) {
            System.out.println(l.toString());
        }
    }
}
