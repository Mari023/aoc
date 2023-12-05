package year2023.day05;

import util.Util;

import java.util.ArrayList;
import java.util.TreeSet;

public class Day05 {
    private static final RangeMap seedToSoil = new RangeMap();
    private static final RangeMap soilToFertilizer = new RangeMap();
    private static final RangeMap fertilizerToWater = new RangeMap();
    private static final RangeMap waterToLight = new RangeMap();
    private static final RangeMap lightToTemperature = new RangeMap();
    private static final RangeMap temperatureToHumidity = new RangeMap();
    private static final RangeMap humidityToLocation = new RangeMap();

    public static void main(String[] args) {
        var seeds = new ArrayList<Long>();

        Util.loopS(Input.INPUT, (block, i) -> {
            if (i == 0) {
                for (String s : block.substring("seeds: ".length()).split(" ")) {
                    seeds.add(Long.parseLong(s));
                }
                return;
            }
            String[] map = block.split(":\n");
            for (String entry : map[1].split("\n")) {
                getMap(map[0]).put(entry);
            }
        });

        var seedSet = new TreeSet<>(seeds);

        var locations = humidityToLocation.map(temperatureToHumidity.map(lightToTemperature.map(waterToLight.map(fertilizerToWater.map(soilToFertilizer.map(seedToSoil.map(seedSet)))))));
        System.out.println(locations.first());

        //part two
        var seeds2 = new ArrayList<RangeMap.Entry>();
        for (int i = 0; i < seeds.size(); i += 2) {
            long start = seeds.get(i);
            long range = seeds.get(i + 1);
            seeds2.add(new RangeMap.Entry(start, 0, range));
        }
        var locationRanges = humidityToLocation.mapRange(temperatureToHumidity.mapRange(lightToTemperature.mapRange(waterToLight.mapRange(fertilizerToWater.mapRange(soilToFertilizer.mapRange(seedToSoil.mapRange(seeds2)))))));
        locationRanges.sort(RangeMap.Entry::compareTo);
        System.out.println(locationRanges.get(0).sourceStart());
    }

    private static RangeMap getMap(String name) {
        return switch (name) {
            case "seed-to-soil map" -> seedToSoil;
            case "soil-to-fertilizer map" -> soilToFertilizer;
            case "fertilizer-to-water map" -> fertilizerToWater;
            case "water-to-light map" -> waterToLight;
            case "light-to-temperature map" -> lightToTemperature;
            case "temperature-to-humidity map" -> temperatureToHumidity;
            case "humidity-to-location map" -> humidityToLocation;
            default -> null;
        };
    }
}
