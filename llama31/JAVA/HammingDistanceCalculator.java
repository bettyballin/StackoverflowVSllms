import java.lang.Integer;
import java.lang.String;

public class HammingDistanceCalculator {
    public static int minHamming(String L, String S) {
        int lenL = L.length();
        int lenS = S.length();
        int mask = (1 << lenS) - 1; // create a bitmask for the shorter string

        int[] bits = new int[lenL + 1];
        for (int i = 0; i < lenL; i++) {
            bits[i + 1] = (bits[i] << 1) | (L.charAt(i) == S.charAt(0) ? 1 : 0);
        }

        int minHamming = lenS; // initialize with maximum possible Hamming distance
        for (int i = lenS - 1; i < lenL; i++) {
            int diff = (bits[i + 1] ^ (mask << (i - lenS + 1))) & mask;
            int hamming = Integer.bitCount(diff);
            if (hamming < minHamming) {
                minHamming = hamming;
            }
        }

        return minHamming;
    }

    public static void main(String[] args) {
        System.out.println(minHamming("abcde", "abc"));
    }
}