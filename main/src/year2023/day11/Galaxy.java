package year2023.day11;

public record Galaxy(int x, int y) {
    public int distance(Galaxy galaxy) {
        return Math.abs(galaxy.x()-x()) + Math.abs(galaxy.y()-y());
    }
}
