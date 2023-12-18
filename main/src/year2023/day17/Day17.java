package year2023.day17;

import util.TimedTest;
import year2023.day10.Position;

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
        nodes[0][0].right = nodes[0][1];
        nodes[0][0].down = nodes[1][0];
        nodes[0][0].distance = 0;


        boolean searching = true;
        while (searching || unvisited.isEmpty()) {
            Node current = getSmallest(unvisited);
            if (current == target) searching = false;
            unvisited.remove(current);
            current.visited = true;
            checkNext(nodes, unvisited, current.right, current, Position.Direction.E);
            checkNext(nodes, unvisited, current.down, current, Position.Direction.S);
            checkNext(nodes, unvisited, current.left, current, Position.Direction.W);
            checkNext(nodes, unvisited, current.up, current, Position.Direction.N);
        }

        if (TimedTest.PRINT) printPath(nodes);
        System.out.println(target.distance);
    }

    private static void checkNext(Node[][] nodes, List<Node> unvisited, Node n, Node previous, Position.Direction from) {
        if (n == null) return;
        //don't allow three consecutive straights
        //FIXME this doesn't work
        //instead, modify graph so the next nodes look like this:
        //####
        //.
        //####
        if (previous.previous != null && previous.previous.previous != null && previous.previousDirection == from && previous.previous.previousDirection == from && previous.previous.previous.previousDirection == from)
            return;
        if (n.distance < previous.distance + n.heatLoss) return;
        n.previous = previous;
        n.previousDirection = from;
        unvisited.remove(n);
        n.distance = previous.distance + n.heatLoss;
        unvisited.add(n);
        n.right = getIfUnvisited(nodes, n.x + 1, n.y);
        n.down = getIfUnvisited(nodes, n.x, n.y + 1);
        n.left = getIfUnvisited(nodes, n.x - 1, n.y);
        n.up = getIfUnvisited(nodes, n.x, n.y - 1);
    }

    private static Node getIfUnvisited(Node[][] nodes, int x, int y) {
        if (y < 0 || y >= nodes.length) return null;
        if (x < 0 || x >= nodes[y].length) return null;
        Node node = nodes[y][x];
        return node.previous == null ? node : null;
    }

    private static Node getSmallest(List<Node> unvisited) {
        Node n = unvisited.get(0);
        for (Node node : unvisited) {
            if (n.compareTo(node) > 0)
                n = node;
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
                    case N -> s.append("v");
                    case S -> s.append("^");
                    case W -> s.append(">");
                    case E -> s.append("<");
                    case NONE -> s.append(n.heatLoss);
                }
            }
            s.append('\n');
        }
        System.out.print(s);
    }
}
