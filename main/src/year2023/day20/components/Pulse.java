package year2023.day20.components;

public record Pulse(Type type, Component sender, String receiver) {
    public enum Type {
        HIGH, LOW
    }
}
