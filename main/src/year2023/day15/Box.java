package year2023.day15;

import java.util.ArrayList;
import java.util.List;

public class Box {
    private final List<Lens> lenses = new ArrayList<>();
    private final List<String> lensCodes = new ArrayList<>();

    public void add(Lens lens) {
        if (lens.isSubtractive && lensCodes.contains(lens.code)) {
            int index = lensCodes.indexOf(lens.code);
            lenses.remove(index);
            lensCodes.remove(index);
        } else if(!lens.isSubtractive) {
            if (lensCodes.contains(lens.code)) {
                lenses.set(lensCodes.indexOf(lens.code), lens);
            } else {
                lenses.add(lens);
                lensCodes.add(lens.code);
            }
        }
    }

    public long focusingPower() {
        long focusingPower = 0;
        for (int i = 0; i < lenses.size(); i++) {
            focusingPower += (long) lenses.get(i).focalLength * (i + 1);
        }
        return focusingPower;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Lens lens : lenses)
            s.append(lens.toString()).append(", ");
        return s.toString();
    }
}
