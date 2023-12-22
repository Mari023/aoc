package year2023.day17;


public record Position(int x, int y, Direction direction) {
    public Position(Node n) {
        this(n.x, n.y, n.previousDirection);
    }

    public Position move(int length, Direction direction) {
        int newX = 0, newY = 0;
        Direction newDirection = null;
        switch (this.direction) {//TODO
            case U -> {
                newY -= length;
                switch (direction) {
                    case L -> {
                        newX++;
                        newDirection = Direction.L;
                    }
                    case R -> {
                        newX--;
                        newDirection = Direction.R;
                    }
                    default -> throw new IllegalArgumentException("Invalid Direction to turn: " + direction);
                }
            }
            case D -> {
                newY += length;
                switch (direction) {
                    case L -> {
                        newX--;
                        newDirection = Direction.R;
                    }
                    case R -> {
                        newX++;
                        newDirection = Direction.L;
                    }
                    default -> throw new IllegalArgumentException("Invalid Direction to turn: " + direction);
                }
            }
            case L -> {
            }
            case R -> {
            }
            case NONE -> {
            }
        }
        return new Position(newX, newY, newDirection);
    }

    public Node getIfUnvisited(Node[][] nodes) {
        if (y < 0 || y >= nodes.length) return null;
        if (x < 0 || x >= nodes[y].length) return null;
        Node node = nodes[y][x];
        return node.previous == null ? node : null;
    }


    public enum Direction {
        U, D, L, R, NONE
    }
}
