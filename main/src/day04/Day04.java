package day04;

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

        List<ScratchCard> wonScratchCards = new ArrayList<>(scratchCards);
        for (int i = 0; i < wonScratchCards.size(); i++) {
            int won = wonScratchCards.get(i).won();
            for (int j = wonScratchCards.get(i).cardNumber(); j < wonScratchCards.get(i).cardNumber() + won; j++) {
                if (j < scratchCards.size()) {
                    wonScratchCards.add(scratchCards.get(j));
                }
            }
        }
        System.out.println(wonScratchCards.size());
    }
}
