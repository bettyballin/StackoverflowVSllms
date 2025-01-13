/*
 * Decompiled with CFR 0.152.
 */
public class UnpredictableRangeWalker {
    private static final long A = 1664525L;
    private static final long C = 1013904223L;
    private static final long M = 0x100000000L;
    private long seed;
    private long current;
    private int rangeStart;
    private int rangeEnd;

    public UnpredictableRangeWalker(int n, int n2, long l) {
        this.seed = l;
        this.current = l;
        this.rangeStart = n;
        this.rangeEnd = n2;
    }

    public int next() {
        this.current = (1664525L * this.current + 1013904223L) % 0x100000000L;
        return (int)(this.current % (long)(this.rangeEnd - this.rangeStart + 1) + (long)this.rangeStart);
    }

    public boolean hasNext() {
        return this.current != this.seed;
    }

    public static void main(String[] stringArray) {
        UnpredictableRangeWalker unpredictableRangeWalker = new UnpredictableRangeWalker(100000, 999999, 42L);
        while (unpredictableRangeWalker.hasNext()) {
            System.out.println(unpredictableRangeWalker.next());
        }
    }
}
