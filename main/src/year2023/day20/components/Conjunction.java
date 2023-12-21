package year2023.day20.components;

import util.MutableLong;

import java.util.*;

public final class Conjunction extends Component {
    private final Map<Component, Pulse.Type> lastPulses = new HashMap<>();
    private final Collection<Pulse.Type> lastPulseValues = lastPulses.values();

    public Conjunction(String name, Map<String, Component> components, MutableLong highPulses, MutableLong lowPulses, List<String> destinationModules) {
        super(name, components, highPulses, lowPulses, destinationModules);
    }

    @Override
    public void pulse(Pulse pulse, List<Pulse> scheduledPulses) {
        lastPulses.replace(pulse.sender(), pulse.type());
        if (lastPulseValues.contains(Pulse.Type.LOW)) {
            sendPulse(Pulse.Type.HIGH, scheduledPulses);
        } else {
            sendPulse(Pulse.Type.LOW, scheduledPulses);
        }
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
