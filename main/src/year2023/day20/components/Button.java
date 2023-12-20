package year2023.day20.components;

import util.MutableLong;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Button extends Component {
    public Button(Map<String, Component> components, MutableLong highPulses, MutableLong lowPulses) {
        super("button", components, highPulses, lowPulses, List.of("broadcaster"));
    }

    @Override
    public void pulse(List<Pulse> pulses, Map<String, List<Pulse>> scheduledPulses) {
    }

    public void push(HashMap<String, List<Pulse>> scheduledPulses) {
        sendPulse(Pulse.Type.LOW, scheduledPulses);
    }
}
