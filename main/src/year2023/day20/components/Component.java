package year2023.day20.components;

import util.MutableLong;

import java.util.List;
import java.util.Map;

public sealed abstract class Component permits Broadcaster, Button, Conjunction, FlipFlop {
    private final String name;
    private final MutableLong highPulses;
    private final MutableLong lowPulses;
    private final List<String> destinationModules;

    public Component(String name, Map<String, Component> components, MutableLong highPulses, MutableLong lowPulses, List<String> destinationModules) {
        this.name = name;
        this.highPulses = highPulses;
        this.lowPulses = lowPulses;
        this.destinationModules = destinationModules;
        components.put(name, this);
    }

    public final String name() {
        return name;
    }

    public abstract void pulse(Pulse pulses, List<Pulse> scheduledPulses);

    protected void sendPulse(Pulse.Type type, List<Pulse> scheduledPulses) {
        switch (type) {
            case HIGH -> highPulses.add(1);
            case LOW -> lowPulses.add(1);
        }
        for (String destinationModule : destinationModules) {
            scheduledPulses.add(new Pulse(type, this, destinationModule));
        }
    }

    public static void of(String string, Map<String, Component> components, MutableLong highPulses, MutableLong lowPulses) {
        String[] s = string.split(" -> ");
        List<String> destinationModules = List.of(s[1].split(", "));
        if (s[0].equals("broadcaster")) {
            new Broadcaster(components, highPulses, lowPulses, destinationModules);
            return;
        }
        if (s[0].startsWith("%")) {
            new FlipFlop(s[0].substring(1), components, highPulses, lowPulses, destinationModules);
            return;
        }
        if (s[0].startsWith("&")) {
            new Conjunction(s[0].substring(1), components, highPulses, lowPulses, destinationModules);
        }
    }
}
