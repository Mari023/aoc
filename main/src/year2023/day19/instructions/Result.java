package year2023.day19.instructions;

public record Result(Type type, String workflow) {
    public static final Result ACCEPTED = new Result(Type.ACCEPTED, "");
    public static final Result REJECTED = new Result(Type.REJECTED, "");
    public enum Type {
        ACCEPTED, REJECTED, MOVED
    }
}
