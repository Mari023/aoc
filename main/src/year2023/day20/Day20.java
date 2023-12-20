package year2023.day20;

import util.MutableLong;
import year2023.day20.components.Button;
import year2023.day20.components.Component;
import year2023.day20.components.Pulse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day20 {
    private static final int buttonPresses = 1000;

    public static void main(String[] args) {
        String[] input = Input.TEST0;
        Map<String, Component> components = new HashMap<>();
        util.MutableLong highPulses = new MutableLong();
        MutableLong lowPulses = new MutableLong();
        Button button = new Button(components, highPulses, lowPulses);
        for (String component : input) {
            Component.of(component, components, highPulses, lowPulses);
        }
        HashMap<String, List<Pulse>> currentScheduledPulses;
        HashMap<String, List<Pulse>> nextScheduledPulses = new HashMap<>();
        for (int i = 0; i < buttonPresses; i++) {
            button.push(nextScheduledPulses);
            while (!nextScheduledPulses.isEmpty()) {
                currentScheduledPulses = nextScheduledPulses;
                nextScheduledPulses = new HashMap<>();
                for (var entry : currentScheduledPulses.entrySet()) {
                    Component component = components.get(entry.getKey());
                    component.pulse(entry.getValue(), nextScheduledPulses);
                }
            }
        }
        System.out.println(highPulses.get() * lowPulses.get());
    }
}
