import java.lang.String;
public class UnpredictableRangeWalker {
    private static final long A = 1664525;
    private static final long C = 1013904223;
    private static final long M = 1L << 32; // 2^32

    private long seed;
    private long current;
    private int rangeStart;
    private int rangeEnd;

    public UnpredictableRangeWalker(int rangeStart, int rangeEnd, long seed) {
        this.seed = seed;
        this.current = seed;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    public int next() {
        current = (A * current + C) % M;
        return (int) ((current % (rangeEnd - rangeStart + 1)) + rangeStart);
    }

    public boolean hasNext() {
        return current != seed;
    }

    public static void main(String[] args) {
        UnpredictableRangeWalker walker = new UnpredictableRangeWalker(100000, 999999, 42);
        while (walker.hasNext()) {
            System.out.println(walker.next());
        }
    }
}