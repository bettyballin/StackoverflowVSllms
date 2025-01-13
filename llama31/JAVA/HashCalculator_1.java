import java.lang.String;

public class HashCalculator_1_1 {
    public static int sparseBitVectorHash(long[] bits, int seed) {
        int hash = seed;
        for (long word : bits) {
            hash = (hash * 0x87d37b91) ^ (int) (word ^ (word >>> 32));
            hash = (hash * 0x85ebca6b) ^ (hash >>> 16);
        }
        return hash & 0x7FFFFFFF; // 31-bit output
    }

    public static void main(String[] args) {
    }
}