import java.util.BitSet;

public class BloomFilter_1 {
    private BitSet bitSet;
    private int size;
    private int hashFunctions;

    public BloomFilter(int size, int hashFunctions) {
        this.size = size;
        this.hashFunctions = hashFunctions;
        this.bitSet = new BitSet(size);
    }

    public void add(String element) {
        for (int seed = 0; seed < hashFunctions; seed++) {
            int hash = hash(element, seed);
            bitSet.set(hash);
        }
    }

    public boolean mightContain(String element) {
        for (int seed = 0; seed < hashFunctions; seed++) {
            int hash = hash(element, seed);
            if (!bitSet.get(hash)) {
                return false;
            }
        }
        return true;
    }

    private int hash(String element, int seed) {
        int hash = element.hashCode() + seed;
        return Math.abs(hash % size);
    }

    public static void main(String[] args) {
        BloomFilter filter = new BloomFilter(1000000, 5);
        filter.add("12345");
        filter.add("23456");
        System.out.println(filter.mightContain("12345")); // true
        System.out.println(filter.mightContain("54321")); // probably false
    }
}