package year2023.day17;

import util.TimedTest;

import java.util.ArrayList;
import java.util.List;

public class Day17 {
    public static void main(String[] args) {
        var input = Input.TEST;
        Node[][] nodes = new Node[input.length][input[0].length()];
        List<Node> unvisited = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                nodes[i][j] = new Node(j, i, Integer.parseInt(String.valueOf(input[i].charAt(j))));
            }
        }
        Node target = nodes[nodes.length - 1][nodes[nodes.length - 1].length - 1];
        unvisited.add(nodes[0][0]);
        nodes[0][0].distance = 0;


        boolean searching = true;
        while (searching || unvisited.isEmpty()) {
            Node current = getSmallest(unvisited);
            if (current == target) searching = false;
            unvisited.remove(current);
            current.visited = true;
            Position p = new Position(current);
            checkNext(nodes, unvisited, p.move(0, Position.Direction.R), current);
            checkNext(nodes, unvisited, p.move(0, Position.Direction.L), current);
            checkNext(nodes, unvisited, p.move(1, Position.Direction.R), current);
            checkNext(nodes, unvisited, p.move(1, Position.Direction.L), current);
            checkNext(nodes, unvisited, p.move(2, Position.Direction.R), current);
            checkNext(nodes, unvisited, p.move(2, Position.Direction.L), current);
            checkNext(nodes, unvisited, p.move(3, Position.Direction.R), current);
            checkNext(nodes, unvisited, p.move(3, Position.Direction.L), current);
        }

        if (TimedTest.PRINT) printPath(nodes);
        System.out.println(target.distance);
    }

    private static void checkNext(Node[][] nodes, List<Node> unvisited, Position p, Node previous) {
        checkNext(unvisited, p.getIfUnvisited(nodes), previous, p.direction());
    }

    private static void checkNext(List<Node> unvisited, Node n, Node previous, Position.Direction from) {
        if (n == null) return;
        if (n.distance < previous.distance + n.heatLoss) return;
        n.previous = previous;
        n.previousDirection = from;
        unvisited.remove(n);
        n.distance = previous.distance + n.heatLoss;
        unvisited.add(n);
    }

    private static Node getSmallest(List<Node> unvisited) {
        Node n = unvisited.get(0);
        for (Node node : unvisited) {
            if (n.compareTo(node) > 0) n = node;
        }
        return n;
    }

    private static void printPath(Node[][] nodes) {
        StringBuilder s = new StringBuilder();
        for (Node[] row : nodes) {
            for (Node n : row) {
                if (!n.visited) {
                    s.append(n.heatLoss);
                    continue;
                }
                switch (n.previousDirection) {
                    case U -> s.append("v");
                    case D -> s.append("^");
                    case L -> s.append(">");
                    case R -> s.append("<");
                    case NONE -> s.append(n.heatLoss);
                }
            }
            s.append('\n');
        }
        System.out.print(s);
    }
}
