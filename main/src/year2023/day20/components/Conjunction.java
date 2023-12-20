package year2023.day20.components;

import util.MutableLong;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Conjunction extends Component {
    private final Map<String, Pulse.Type> lastPulses;

    public Conjunction(String name, Map<String, Component> components, MutableLong highPulses, MutableLong lowPulses, List<String> destinationModules) {
        super(name, components, highPulses, lowPulses, destinationModules);
        lastPulses = new HashMap<>();
        for (String destinationModule : destinationModules) {
            lastPulses.put(destinationModule, Pulse.Type.LOW);
        }
    }

    @Override
    public void pulse(List<Pulse> pulses, Map<String, List<Pulse>> scheduledPulses) {
        for (Pulse pulse : pulses) {
            lastPulses.put(pulse.sender().name(), pulse.type());
            Pulse.Type toSend = Pulse.Type.LOW;
            for (var entry : lastPulses.values()) {
                if (entry == Pulse.Type.LOW) {
                    toSend = Pulse.Type.HIGH;
                    break;
                }
            }
            sendPulse(toSend, scheduledPulses);
        }
    }
}
