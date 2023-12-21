package year2023.day20.components;

public record Pulse(Type type, Component sender, String receiver) {
    @Override
    public String toString() {
        return "Pulse{type=" + type + ", sender=" + sender.name() + ", receiver=" + receiver + '}';
    }

    public enum Type {
        HIGH, LOW
    }
}
