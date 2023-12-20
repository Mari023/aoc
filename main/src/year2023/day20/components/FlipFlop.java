package year2023.day20.components;

import util.MutableLong;

import java.util.List;
import java.util.Map;

public final class FlipFlop extends Component {
    private boolean isOn = false;

    public FlipFlop(String name, Map<String, Component> components, MutableLong highPulses, MutableLong lowPulses, List<String> destinationModules) {
        super(name, components, highPulses, lowPulses, destinationModules);
    }

    @Override
    public void pulse(List<Pulse> pulses, Map<String, List<Pulse>> scheduledPulses) {
        for (Pulse pulse : pulses) {
            if (pulse.type() == Pulse.Type.HIGH) continue;
            isOn = !isOn;
            if (isOn) sendPulse(Pulse.Type.HIGH, scheduledPulses);
            else sendPulse(Pulse.Type.LOW, scheduledPulses);
        }
    }
}
