package year2023.day15;

import util.TimedTest;

import java.util.ArrayList;
import java.util.List;

public class Day15 {
    public static void main(String[] args) {
        List<Lens> lenses = new ArrayList<>();
        long solution = 0;
        for (String s : Input.TEST) {
            Lens l = Lens.of(s);
            lenses.add(l);
            solution += l.hash;
        }
        System.out.println(solution);

        HASHMAP hashmap = new HASHMAP(lenses);
        if(TimedTest.PRINT) System.out.println(hashmap);
        System.out.println(hashmap.focusingPower());
    }
}
