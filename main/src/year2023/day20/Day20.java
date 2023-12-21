package year2023.day20;

import util.MutableLong;
import year2023.day20.components.Button;
import year2023.day20.components.Component;
import year2023.day20.components.DummyComponent;
import year2023.day20.components.Pulse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day20 {

    public static void main(String[] args) {
        System.out.println(new Day20().part1());
        System.out.println(new Day20().part2());
    }

    private final Button button;
    private final DummyComponent rx;
    private List<Pulse> nextScheduledPulses;
    private final MutableLong highPulses;
    private final MutableLong lowPulses;

    private Day20() {
        String[] input = Input.INPUT;
        Map<String, Component> components = new HashMap<>();
        highPulses = new MutableLong();
        lowPulses = new MutableLong();
        button = new Button(components, highPulses, lowPulses);
        rx = new DummyComponent("rx");
        for (String component : input) {
            Component.of(component, components, highPulses, lowPulses);
        }
        components.forEach((name, component) -> component.connectComponents(components));
        nextScheduledPulses = new ArrayList<>();
    }

    private long part1() {
        for (int i = 0; i < 1000; i++) {
            handleButtonPress();
        }
        return highPulses.get() * lowPulses.get();
    }

    private long part2() {
        long presses = 0;
        while (!rx.receivedLowPulse()) {
            handleButtonPress();
            presses++;
        }
        return presses;
    }

    private void handleButtonPress() {
        button.push(nextScheduledPulses);
        while (!nextScheduledPulses.isEmpty()) {
            List<Pulse> currentScheduledPulses = nextScheduledPulses;
            nextScheduledPulses = new ArrayList<>(32);
            for (var pulse : currentScheduledPulses) {
                pulse.receiver().pulse(pulse, nextScheduledPulses);
            }
        }
    }
}
