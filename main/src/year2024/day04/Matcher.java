package year2024.day04;

public class Matcher {
    private long matches;
    private State state;

    public void consume(char c) {
        state = switch (state) {
            case START -> switch (c) {
                case 'X' -> State.X;
                case 'S' -> State.S_R;
                default -> State.START;
            };
            case X -> switch (c) {
                case 'X' -> State.X;
                case 'S' -> State.S_R;
                case 'M' -> State.M;
                default -> State.START;
            };
            case M -> switch (c) {
                case 'X' -> State.X;
                case 'S' -> State.S_R;
                case 'A' -> State.A;
                default -> State.START;
            };
            case A -> switch (c) {
                case 'X' -> State.X;
                case 'S' -> {
                    matches++;
                    yield State.S_R;
                }
                default -> State.START;
            };
            case S_R -> switch (c) {
                case 'X' -> State.X;
                case 'S' -> State.S_R;
                case 'A' -> State.A_R;
                default -> State.START;
            };
            case A_R -> switch (c) {
                case 'X' -> State.X;
                case 'S' -> State.S_R;
                case 'M' -> State.M_R;
                default -> State.START;
            };
            case M_R -> switch (c) {
                case 'X' -> {
                    matches++;
                    yield State.X;
                }
                case 'S' -> State.S_R;
                default -> State.START;
            };
        };
    }

    public void newLine() {
        state = State.START;
    }

    public long matches() {
        return matches;
    }

    private enum State {
        START, X, M, A, S_R, A_R, M_R
    }
}
