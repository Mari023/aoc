package year2023.day20.components;

import util.MutableLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public sealed abstract class Component permits Broadcaster, Button, DummyComponent, Conjunction, FlipFlop {
    private final String name;
    private final MutableLong highPulses;
    private final MutableLong lowPulses;
    protected final List<String> destinationModuleNames;
    private final List<Component> destinationModules = new ArrayList<>();
    protected final int id;

    public Component(String name, Map<String, Component> components, MutableLong highPulses, MutableLong lowPulses, List<String> destinationModules) {
        this.name = name;
        this.highPulses = highPulses;
        this.lowPulses = lowPulses;
        this.destinationModuleNames = destinationModules;
        id = components.size();
        components.put(name, this);
    }

    public final String name() {
        return name;
    }

    public abstract void pulse(Pulse pulse, List<Pulse> scheduledPulses);

    protected void sendPulse(Pulse.Type type, List<Pulse> scheduledPulses) {
        switch (type) {
            case HIGH -> highPulses.add(destinationModules.size());
            case LOW -> lowPulses.add(destinationModules.size());
        }
        for (Component destinationModule : destinationModules) {
            scheduledPulses.add(new Pulse(type, this, destinationModule));
        }
    }

    public void connectComponents(Map<String, Component> components) {
        for (String name : destinationModuleNames) {
            Component component = components.get(name);
            if (component == null) component = new DummyComponent(name);
            destinationModules.add(component);
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

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
