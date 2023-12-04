package day04;

import util.Util;

public record ScratchCard(int cardNumber, int[] picked, int[] correct, int won) {
    public static ScratchCard create(String s) {
        String[] columns = s.split(" \\| +");
        String[] column1 = columns[0].split(": +");
        int cardNumber = Integer.parseInt(column1[0].replaceAll("Card +", ""));
        String[] pickedStrings = column1[1].split(" +");
        String[] correctStrings = columns[1].split(" +");
        int[] picked = new int[pickedStrings.length];
        int[] correct = new int[correctStrings.length];

        Util.loopS(pickedStrings, (value, i) -> picked[i] = Integer.parseInt(value));
        Util.loopS(correctStrings, (value, i) -> correct[i] = Integer.parseInt(value));


        int won = 0;
        for (int i : picked) {
            for (int c : correct) {
                if (c == i) {
                    won++;
                    break;
                }
            }
        }

        return new ScratchCard(cardNumber, picked, correct, won);
    }

    public int getPoints() {
        if (won <= 0)
            return 0;
        return (int) Math.pow(2, (won - 1));
    }
}
