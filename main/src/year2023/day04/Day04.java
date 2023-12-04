package year2023.day04;

import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Day04 {
    public static void main(String[] args) {
        List<ScratchCard> scratchCards = new ArrayList<>();
        Util.loopS(Input.INPUT, (s, i) -> scratchCards.add(ScratchCard.create(s)));

        long result = 0;
        for (ScratchCard scratchCard : scratchCards) {
            result += scratchCard.getPoints();
        }
        System.out.println(result);

        long count = 0;
        int[] wonScratchCards = new int[scratchCards.size()];
        for (int i = 0; i < wonScratchCards.length; i++) {
            count += wonScratchCards[i] + 1;
            for (int j = scratchCards.get(i).cardNumber(); j < scratchCards.get(i).cardNumber() + scratchCards.get(i).won(); j++) {
                if (j < scratchCards.size()) {
                    wonScratchCards[j] += wonScratchCards[i] + 1;
                }
            }
        }
        System.out.println(count);
    }
}
