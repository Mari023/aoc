package year2023.day05;

import util.Util;

import java.util.TreeSet;

public class RangeMap {
    private final TreeSet<Entry> entries = new TreeSet<>();

    public TreeSet<Long> map(TreeSet<Long> set) {
        var result = new TreeSet<Long>();
        for (Long key : set) {
            var entry = entries.floor(new Entry(key));
            if (entry == null) continue;
            if (entry.range() >= key - entry.sourceStart())
                result.add(entry.destinationStart() + key - entry.sourceStart());
        }
        return result;
    }

    public void put(String entryString) {
        String[] values = entryString.split(" ");
        entries.add(new Entry(Long.parseLong(values[1]), Long.parseLong(values[0]), Long.parseLong(values[2])));
    }

    private record Entry(long sourceStart, long destinationStart, long range) implements Comparable<Entry> {
        private Entry(long start) {
            this(start, start, -1);
        }

        @Override
        public int compareTo(Entry entry) {
            return (int) Util.clamp(Integer.MIN_VALUE, sourceStart() - entry.sourceStart(), Integer.MAX_VALUE);
        }
    }
}
