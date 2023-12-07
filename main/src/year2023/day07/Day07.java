package year2023.day07;

import java.util.ArrayList;

public class Day07 {
    public static void main(String[] args) {
        var hands = new ArrayList<Hand>();
        for (String s : Input.INPUT) {
            String[] input = s.split(" ");
            Card[] cards = new Card[5];

            for (int i = 0; i < cards.length; i++) {
                cards[i] = Card.fromChar(input[0].charAt(i));
            }

            hands.add(new Hand(cards, Integer.parseInt(input[1])));
        }

        hands.sort(Hand::compareTo);

        long result = 0;
        for (int i = 0; i < hands.size(); i++) {
            result += hands.get(i).bet() * (i + 1);
        }
        System.out.println(result);
    }
}
