package year2023.day20.components;

import util.MutableLong;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Conjunction extends Component {
    private final Map<Component, Pulse.Type> lastPulses = new HashMap<>();

    public Conjunction(String name, Map<String, Component> components, MutableLong highPulses, MutableLong lowPulses, List<String> destinationModules) {
        super(name, components, highPulses, lowPulses, destinationModules);
    }

    @Override
    public void pulse(Pulse pulse, List<Pulse> scheduledPulses) {
        lastPulses.put(pulse.sender(), pulse.type());
        Pulse.Type toSend = Pulse.Type.LOW;
        for (var entry : lastPulses.values()) {
            if (entry == Pulse.Type.LOW) {
                toSend = Pulse.Type.HIGH;
                break;
            }
        }
        sendPulse(toSend, scheduledPulses);
    }

    @Override
    public void connectComponents(Map<String, Component> components) {
        super.connectComponents(components);
        for (Component component : components.values()) {
            if (component.destinationModuleNames.contains(name())) {
                lastPulses.put(component, Pulse.Type.LOW);
            }
        }
    }
}
