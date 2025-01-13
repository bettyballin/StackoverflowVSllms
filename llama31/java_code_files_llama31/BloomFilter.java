/*
 * Decompiled with CFR 0.152.
 */
import java.util.BitSet;

public class BloomFilter {
    private final BitSet bitSet;
    private final int hashFunctions;
    private final int size;

    public BloomFilter(int n, int n2) {
        this.size = n;
        this.hashFunctions = n2;
        this.bitSet = new BitSet(n);
    }

    public void add(String string) {
        for (int i = 0; i < this.hashFunctions; ++i) {
            int n = this.hash(string, i) % this.size;
            this.bitSet.set(n);
        }
    }

    public boolean mightContain(String string) {
        for (int i = 0; i < this.hashFunctions; ++i) {
            int n = this.hash(string, i) % this.size;
            if (this.bitSet.get(n)) continue;
            return false;
        }
        return true;
    }

    private int hash(String string, int n) {
        int n2 = string.hashCode() + n;
        return n2;
    }

    public static void main(String[] stringArray) {
    }
}
