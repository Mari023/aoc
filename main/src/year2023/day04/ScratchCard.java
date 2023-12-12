package year2023.day04;

import util.Util;

import java.util.regex.Pattern;

public record ScratchCard(int cardNumber, int[] picked, int[] correct, int won) {
    private static final Pattern PIPE = Pattern.compile(" \\| +");
    private static final Pattern COLON = Pattern.compile(": +");
    private static final Pattern CARD = Pattern.compile("Card +");
    private static final Pattern SPACE = Pattern.compile(" +");

    public static ScratchCard create(String s) {
        String[] columns = PIPE.split(s);
        String[] column1 = COLON.split(columns[0]);
        int cardNumber = Integer.parseInt(CARD.matcher(column1[0]).replaceAll(""));
        String[] pickedStrings = SPACE.split(column1[1]);
        String[] correctStrings = SPACE.split(columns[1]);
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
