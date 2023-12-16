package year2023.day16;

public class Beam {
    public int x;
    public int y;
    public Direction direction;

    public Beam(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Beam() {
        this(0, 0, Direction.East);
    }

    public Beam(Beam beam, Direction direction) {
        this(beam.x, beam.y, direction);
    }

    public Beam move(char c) {
        Beam result = null;
        switch (direction) {
            case North -> {
                switch (c) {
                    case '/' -> direction = Direction.East;
                    case '\\' -> direction = Direction.West;
                    case '-' -> {
                        direction = Direction.East;
                        result = new Beam(this, Direction.West);
                    }
                }
            }
            case East -> {
                switch (c) {
                    case '/' -> direction = Direction.North;
                    case '\\' -> direction = Direction.South;
                    case '|' -> {
                        direction = Direction.North;
                        result = new Beam(this, Direction.South);
                    }
                }
            }
            case South -> {
                switch (c) {
                    case '/' -> direction = Direction.West;
                    case '\\' -> direction = Direction.East;
                    case '-' -> {
                        direction = Direction.East;
                        result = new Beam(this, Direction.West);
                    }
                }
            }
            case West -> {
                switch (c) {
                    case '/' -> direction = Direction.South;
                    case '\\' -> direction = Direction.North;
                    case '|' -> {
                        direction = Direction.North;
                        result = new Beam(this, Direction.South);
                    }
                }
            }
        }

        switch (direction) {
            case North -> y--;
            case East -> x++;
            case South -> y++;
            case West -> x--;
        }
        return result;
    }

    public boolean outOfBounds(int xBound, int yBound) {
        return x < 0 || y < 0 || x >= xBound || y >= yBound;
    }

    public enum Direction {
        North(0b0001), East(0b0010), South(0b0100), West(0b1000);
        public final int id;

        Direction(int id) {
            this.id = id;
        }
    }
}
