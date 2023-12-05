package year2023.day05;

import util.Util;

import java.util.ArrayList;
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

    public ArrayList<Entry> mapRange(ArrayList<Entry> toMap) {
        var result = new ArrayList<Entry>();
        for (int i = 0; i < toMap.size(); i++) {
            Entry key = toMap.get(i);
            var entry = this.entries.floor(key);
            if (entry == null) continue;
            if (key.sourceStart() >= entry.sourceStart() + entry.range()) {
                //we are beyond the end of the entries range, but maybe the next entry is partially in our range
                entry = this.entries.higher(entry);
                if (entry == null) continue;
                if (entry.sourceStart() < key.sourceStart() + key.range()) {
                    toMap.add(new Entry(entry.sourceStart(), 0, key.range() - (entry.sourceStart() - key.sourceStart())));
                }
                continue;
            }
            long relativeEntryRange = entry.sourceStart() + entry.range() - key.sourceStart();

            result.add(new Entry(entry.destinationStart() + key.sourceStart() - entry.sourceStart(), 0, Math.min(key.range(), relativeEntryRange)));
            if (relativeEntryRange < key.range()) {
                //we went over the end of the entry we found, but we still need to map this
                toMap.add(new Entry(entry.sourceStart() + entry.range(), 0, key.range() - relativeEntryRange));
            }
        }
        return result;
    }

    public void put(String entryString) {
        String[] values = entryString.split(" ");
        entries.add(new Entry(Long.parseLong(values[1]), Long.parseLong(values[0]), Long.parseLong(values[2])));
    }

    public record Entry(long sourceStart, long destinationStart, long range) implements Comparable<Entry> {
        private Entry(long start) {
            this(start, start, -1);
        }

        @Override
        public int compareTo(Entry entry) {
            return (int) Util.clamp(Integer.MIN_VALUE, sourceStart() - entry.sourceStart(), Integer.MAX_VALUE);
        }
    }
}
