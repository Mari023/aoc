package year2023.day20.components;

import util.MutableLong;

import java.util.List;
import java.util.Map;

public final class Broadcaster extends Component {

    public Broadcaster(Map<String, Component> components, MutableLong highPulses, MutableLong lowPulses, List<String> destinationModules) {
        super("broadcaster", components, highPulses, lowPulses, destinationModules);
    }

    @Override
    public void pulse(List<Pulse> pulses, Map<String, List<Pulse>> scheduledPulses) {
        for (Pulse pulse : pulses) {
            sendPulse(pulse.type(), scheduledPulses);
        }
    }
}
