package year2023.day02;

public record Round(int red, int green, int blue) {
    public int getPower() {
        return red * green * blue;
    }
}
