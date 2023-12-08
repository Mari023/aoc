package year2023.day07.part2;

import year2023.day07.Type;

import java.util.EnumMap;

public record Hand(Card[] cards, long bet) implements Comparable<Hand> {
    @Override
    public int compareTo(Hand hand) {
        int type = getType().compareTo(hand.getType());
        if (type == 0) {
            return -compareCards(hand);
        }
        return -type;
    }

    private int compareCards(Hand hand) {
        for (int i = 0; i < cards().length; i++) {
            int compare = cards()[i].compareTo(hand.cards()[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    private Type getType() {
        EnumMap<Card, Integer> map = new EnumMap<>(Card.class);
        for (Card card : cards) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        int joker = map.getOrDefault(Card.J, 0);
        map.remove(Card.J);
        if (joker == 5) return Type.FiveOfAKind;

        boolean threeCards = false;
        int twoCards = 0;
        for (var entry : map.entrySet()) {
            if (entry.getValue() + joker == 5) return Type.FiveOfAKind;
            if (entry.getValue() + joker == 4) return Type.FourOfAKind;
            if (entry.getValue() == 3) {
                threeCards = true;
            } else if (entry.getValue() == 2) {
                twoCards++;
            }
        }
        if (threeCards && twoCards == 1) return Type.FullHouse;
        if (threeCards) return Type.ThreeOfAKind;

        if (twoCards == 2 && joker == 1) return Type.FullHouse;
        if (twoCards == 2) return Type.TwoPair;
        if (twoCards == 1 && joker == 1) return Type.ThreeOfAKind;
        if (twoCards == 1) return Type.OnePair;

        if (joker == 2) return Type.ThreeOfAKind;
        if (joker == 1) return Type.OnePair;

        return Type.HighCard;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Hand{");
        for (Card c : this.cards()) {
            s.append(c.toString());
        }
        s.append("},");
        s.append(bet());
        return s.toString();
    }

}
