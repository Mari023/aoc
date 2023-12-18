package year2023.day18;

public record Operation(Direction direction, int length, String color) {

    public static Operation of(String s) {
        var values = s.split(" ");
        return new Operation(Direction.of(values[0]), Integer.parseInt(values[1]), values[2].substring(1, values[2].length() - 2));
    }

    public enum Direction {
        U, D, L, R;

        public static Direction of(String s) {
            return switch (s) {
                case "U" -> U;
                case "D" -> D;
                case "L" -> L;
                case "R" -> R;
                default -> throw new IllegalArgumentException();
            };
        }
    }
}
