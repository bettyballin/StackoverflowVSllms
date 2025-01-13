import java.lang.String;

public class BitVectorHashCalculator {
    public static int sparseBitVectorHash(long[] bits, int seed) {
        int hash = seed;
        for (long word : bits) {
            hash = (hash * 0x87d37b91) ^ Long.hashCode(word);
        }
        return hash & 0xFFFFFFFF; // 32-bit output
    }

    public static void main(String[] args) {
        // Example usage:
        long[] bits = {1L, 2L, 3L};
        int seed = 123;
        int hash = sparseBitVectorHash(bits, seed);
        System.out.println("Hash: " + hash);
    }
}