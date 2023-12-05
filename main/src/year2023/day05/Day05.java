package year2023.day05;

import util.Util;

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
        var seeds = new TreeSet<Long>();

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

        var locations = humidityToLocation.map(temperatureToHumidity.map(lightToTemperature.map(waterToLight.map(fertilizerToWater.map(soilToFertilizer.map(seedToSoil.map(seeds)))))));
        System.out.println(locations.first());
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
