package util;

public class MutableLong {
    private long l;

    public MutableLong(long l) {
        this.l = l;
    }

    public MutableLong() {
        this(0);
    }

    public long get() {
        return l;
    }

    public void set(long l) {
        this.l = l;
    }

    public void add(long l) {
        this.l += l;
    }

    @Override
    public String toString() {
        return "" + l;
    }
}
