package year2023.day15;

import java.util.List;

public class HASHMAP {
    private final Box[] boxes = new Box[256];

    public HASHMAP(List<Lens> lenses) {
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new Box();
        }
        for (Lens lens : lenses) {
            boxes[lens.hash].add(lens);
        }
    }

    public long focusingPower() {
        long focusingPower = 0;
        for (int i = 0; i < boxes.length; i++) {
            focusingPower += (i + 1) * boxes[i].focusingPower();
        }
        return focusingPower;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < boxes.length; i++)
            s.append("Box ").append(i).append(": ").append(boxes[i].toString()).append("\n");
        return s.toString();
    }
}
