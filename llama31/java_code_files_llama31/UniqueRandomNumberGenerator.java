/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import java.util.BitSet;

public class UniqueRandomNumberGenerator {
    private static final int MAX_NUMBER = 9999999;
    private static final int BLOOM_FILTER_SIZE = 10000000;
    private static final int NUM_HASH_FUNCTIONS = 3;
    private final SecureRandom random = new SecureRandom();
    private final BitSet bloomFilter = new BitSet(10000000);

    public int generateUniqueNumber() {
        int n;
        while (this.bloomFilter.get(n = this.random.nextInt(10000000))) {
        }
        this.bloomFilter.set(n);
        return n;
    }

    public static void main(String[] stringArray) {
    }
}
