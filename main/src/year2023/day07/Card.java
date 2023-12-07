package year2023.day07;

public enum Card implements Comparable<Card> {
    A, K, Q, J, T, N9, N8, N7, N6, N5, N4, N3, N2;

    public static Card fromChar(char c) {
        return switch (c) {
            case 'A' -> A;
            case 'K' -> K;
            case 'Q' -> Q;
            case 'J' -> J;
            case 'T' -> T;
            case '9' -> N9;
            case '8' -> N8;
            case '7' -> N7;
            case '6' -> N6;
            case '5' -> N5;
            case '4' -> N4;
            case '3' -> N3;
            case '2' -> N2;
            default -> null;
        };
    }


    @Override
    public String toString() {
        return name().replaceAll("N", "");
    }
}
