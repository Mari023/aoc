package year2023.day17;


public record Position(int x, int y, Direction direction) {
    public Position(Node n) {
        this(n.x, n.y, n.previousDirection);
    }

    public Position move(int length, Direction direction) {
        int newX = 0, newY = 0;
        Direction newDirection = null;
        switch (this.direction()) {
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
                newX -= length;
                switch (direction) {
                    case L -> {
                        newY++;
                        newDirection = Direction.D;
                    }
                    case R -> {
                        newY--;
                        newDirection = Direction.U;
                    }
                    default -> throw new IllegalArgumentException("Invalid Direction to turn: " + direction);
                }
            }
            case R -> {
                newX += length;
                switch (direction) {
                    case L -> {
                        newY--;
                        newDirection = Direction.U;
                    }
                    case R -> {
                        newY++;
                        newDirection = Direction.D;
                    }
                    default -> throw new IllegalArgumentException("Invalid Direction to turn: " + direction);
                }
            }
            case NONE -> throw new IllegalArgumentException("Trying to turn from " + this.direction());
        }
        return new Position(newX, newY, newDirection);
    }

    public Node getIfUnvisited(Node[][] nodes) {
        if (y < 0 || y >= nodes.length) return null;
        if (x < 0 || x >= nodes[y].length) return null;
        Node node = nodes[y][x];
        return node.visited ? null : node;
    }


    public enum Direction {
        U, D, L, R, NONE
    }
}
