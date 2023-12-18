package year2023.day18;

public record Position(int x, int y) {
    public boolean outOfBounds(int maxX, int maxY) {
        return x < 0 || y < 0 || x >= maxX || y >= maxY;
    }

    public Position right() {
        return new Position(x + 1, y);
    }

    public Position down() {
        return new Position(x, y + 1);
    }

    public Position left() {
        return new Position(x - 1, y);
    }

    public Position up() {
        return new Position(x, y - 1);
    }
}
