package year2023.day08;

import util.MutableLong;

import java.util.*;

public class Day08 {
    public static final boolean DAY08_PART2_DISABLED = true;

    public static void main(String[] args) {
        String directions = Input.INPUT[0];
        Map<String, Node> nodes = new HashMap<>();
        for (String s : Input.INPUT[1].split("\n")) {
            Node n = Node.of(s);
            nodes.put(n.ID(), n);
        }

        nodes.forEach((s, n) -> {
            n.leftNode = nodes.get(n.left);
            n.rightNode = nodes.get(n.right);
        });


        long steps = 0;
        Node current = nodes.get("AAA");
        while (!current.equals("ZZZ")) {
            if (directions.charAt((int) (steps % directions.length())) == 'L') {
                current = current.left();
            } else {
                current = current.right();
            }
            steps++;
        }
        System.out.println(steps);
        if (DAY08_PART2_DISABLED) return;

        List<Node> startNodes = new ArrayList<>();
        Set<Node> endNodes = new HashSet<>();
        nodes.forEach((s, n) -> {
            if (s.charAt(2) == 'A') {
                startNodes.add(n);
            } else if (s.charAt(2) == 'Z') {
                endNodes.add(n);
            }
        });

        nodes.forEach((s, n) -> {
            Node node = n;
            for (int i = 0; i < directions.length(); i++) {
                if (directions.charAt(i) == 'L') {
                    node = node.left();
                } else {
                    node = node.right();
                }
            }
            n.instructions = node;
        });

        long step = directions.length();
        for (var e : nodes.entrySet()) {
            Node n = e.getValue().instructions;
            steps = step;
            while (!endNodes.contains(n)) {
                n = n.instructions;
                steps += step;
            }
            e.getValue().nextEndNode = n;
            e.getValue().stepsToEndNode = steps;
        }

        long[] count = new long[startNodes.size()];
        Object[] currentNodes = startNodes.toArray();
        MutableLong mostSteps = new MutableLong(1);
        while (count[0] == 0 || hasDifferentValues(count)) {
            for (int i = 0; i < currentNodes.length; i++) {
                Node n = (Node) currentNodes[i];
                if (count[i] <= mostSteps.get()) {
                    count[i] += n.stepsToEndNode;
                    if (count[i] > mostSteps.get()) {
                        mostSteps.set(count[i]);
                    }
                    currentNodes[i] = n.nextEndNode;
                }
            }
        }
        System.out.println(count[0]);
    }

    private static boolean hasDifferentValues(long[] longs) {
        long i = longs[0];
        for (long j : longs) {
            if (i != j) return true;
        }
        return false;
    }
}
