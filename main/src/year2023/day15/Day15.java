package year2023.day15;

import util.TimedTest;

import java.util.ArrayList;
import java.util.List;

public class Day15 {
    public static void main(String[] args) {
        List<Lens> lenses = new ArrayList<>();
        long solution = 0;
        for (String s : Input.INPUT) {
            lenses.add(Lens.of(s));
            solution += Lens.hash(s);
        }
        System.out.println(solution);

        HASHMAP hashmap = new HASHMAP(lenses);
        if(TimedTest.PRINT) System.out.println(hashmap);
        System.out.println(hashmap.focusingPower());
    }
}
