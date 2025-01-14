import java.lang.String;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.BitSet;

public class BloomFilter {
    private int size;
    private BitSet bitset;
    private int[] seeds;
    private SimpleHash[] func;

    public BloomFilter(int cap, int k) {
        size = getOptimalSize(cap, k);
        bitset = new BitSet(size);
        seeds = new int[k];
        for (int i = 0; i < k; i++) {
            seeds[i] = (i + 1) * 1357;
        }
        func = new SimpleHash[seeds.length];
        for (int j = 0; j < seeds.length; j++) {
            func[j] = new SimpleHash(size, seeds[j]);
        }
    }

    public boolean add(Object value) {
        boolean ret = true;
        for (SimpleHash f : func) {
            int hash = f.hash(value);
            ret &= bitset.get(hash) | bitset.get(hash);
            bitset.set(hash, true);
        }
        return ret;
    }

    public boolean contains(Object value) {
        if (value == null) {
            return false;
        }
        boolean ret = true;
        for (SimpleHash f : func) {
            ret &= bitset.get(f.hash(value));
        }
        return ret;
    }

    private int getOptimalSize(int cap, int k) {
        int size = (int) (-cap * Math.log(0.01) / Math.pow(k, 2));
        return size;
    }

    public static class SimpleHash {
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(Object value) {
            BigInteger m = new BigInteger("2").pow(31);
            BigInteger a = BigInteger.valueOf(seed).multiply(BigInteger.valueOf(value.hashCode()));
            return Math.abs(a.mod(m).intValue()) % cap;
        }
    }

    public static void main(String[] args) {
        BloomFilter filter = new BloomFilter(80 * 1000, 4); // 80k capacity, with 4 hash functions
        String zipCode = "12345";
        filter.add(zipCode);
        System.out.println(filter.contains("12345")); // should return true
        System.out.println(filter.contains("67890")); // may return false or true (false positive)
    }
}