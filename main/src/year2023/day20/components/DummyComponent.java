package year2023.day20.components;


import util.MutableLong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class DummyComponent extends Component {
    private boolean receivedLowPulse = false;
    public DummyComponent(String name) {
        super(name, new HashMap<>(), new MutableLong(), new MutableLong(), new ArrayList<>());
    }

    @Override
    public void pulse(Pulse pulse, List<Pulse> scheduledPulses) {
        if(pulse.type() == Pulse.Type.LOW) receivedLowPulse = true;
    }

    public boolean receivedLowPulse() {
        return receivedLowPulse;
    }
}