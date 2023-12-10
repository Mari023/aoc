package year2023.day10;

public class Position {
    private int x;
    private int y;

    private long steps;
    public Direction from;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position position)) return false;

        if (x != position.x) return false;
        return y == position.y;
    }

    public Position move(Direction d) {
        switch (d) {
            case N -> {
                y--;
                from = Direction.S;
            }
            case S -> {
                y++;
                from = Direction.N;
            }
            case W -> {
                x--;
                from = Direction.E;
            }
            case E -> {
                x++;
                from = Direction.W;
            }
            case NONE -> throw new IllegalStateException("Trying to move in Direction: NONE");
        }
        steps++;
        return this;
    }

    public boolean move(char c) {
        Direction toMove = Pipe.of(c).otherSide(from);
        if (toMove == Direction.NONE) return true;
        move(toMove);
        return false;
    }

    public long steps() {
        return steps;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public enum Direction {
        N, S, W, E, NONE
    }

    public enum Pipe {
        NS(Direction.N, Direction.S), WE(Direction.W, Direction.E), NE(Direction.N, Direction.E), NW(Direction.N, Direction.W), SE(Direction.S, Direction.E), SW(Direction.S, Direction.W), NONE(Direction.NONE, Direction.NONE);

        public final Direction connectionA;
        public final Direction connectionB;

        Pipe(Direction connectionA, Direction connectionB) {
            this.connectionA = connectionA;
            this.connectionB = connectionB;
        }

        public Direction otherSide(Direction in) {
            if (in == connectionA) return connectionB;
            if (in == connectionB) return connectionA;
            return Direction.NONE;
        }

        public static Pipe of(char c) {
            return switch (c) {
                case '║' -> NS;
                case '═' -> WE;
                case '╚' -> NE;
                case '╝' -> NW;
                case '╗' -> SW;
                case '╔' -> SE;
                default -> NONE;
            };
        }
    }
}
