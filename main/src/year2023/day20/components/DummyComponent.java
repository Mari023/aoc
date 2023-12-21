package year2023.day20.components;


import util.MutableLong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

final class DummyComponent extends Component {
    public DummyComponent(String name) {
        super(name, new HashMap<>(), new MutableLong(), new MutableLong(), new ArrayList<>());
    }

    @Override
    public void pulse(Pulse pulses, List<Pulse> scheduledPulses) {
    }
}