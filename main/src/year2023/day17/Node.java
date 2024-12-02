package year2023.day17;

public class Node implements Comparable<Node> {
    public final int x;
    public final int y;
    public final int heatLoss;
    public final int weightedCost;
    public int distance = Integer.MAX_VALUE;
    public Node previous = null;
    public Position.Direction previousDirection = Position.Direction.NONE;
    public boolean visited = false;

    public Node(int x, int y, int heatLoss) {
        this.x = x;
        this.y = y;
        this.heatLoss = heatLoss;
        this.weightedCost = heatLoss;//TODO use a better heuristic
    }

    @Override
    public int compareTo(Node node) {
        return distance - node.distance;
    }

}
