package year2023.day08;

public class Node {
    private final String ID;
    private final int hashcode;

    public final String left;
    public final String right;

    public Node rightNode;
    public Node leftNode;

    public Node instructions;

    public Node nextEndNode;
    public long stepsToEndNode;

    public Node(String id, String left, String right) {
        ID = id;
        hashcode = ID.hashCode();
        this.left = left;
        this.right = right;
    }

    public static Node of(String s) {
        String[] input = s.split(" = \\(");
        String[] directions = input[1].split(", ");
        return new Node(input[0], directions[0], directions[1].replaceAll("\\)", ""));
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    public boolean equals(String s) {
        return ID.equals(s);
    }

    @Override
    public int hashCode() {
        return hashcode;
    }

    public String ID() {
        return ID;
    }

    public Node left() {
        return leftNode;
    }

    public Node right() {
        return rightNode;
    }

    public Node applyInstructions() {
        return instructions;
    }
}
