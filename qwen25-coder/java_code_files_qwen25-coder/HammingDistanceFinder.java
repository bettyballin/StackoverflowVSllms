import java.lang.String;
import java.lang.Integer;
public class HammingDistanceFinder {
    public static int minHamming(String L, String S) {
        int sLen = S.length();
        int lLen = L.length();

        // Convert strings to numeric representations based on alphabetic order.
        int[] lNum = new int[lLen];
        int[] sNum = new int[sLen];
        for (int i = 0; i < lLen; i++) lNum[i] = charToNumber(L.charAt(i));
        for (int i = 0; i < sLen; i++) sNum[i] = charToNumber(S.charAt(i));

        // Calculate hash values for S and the first window of L.
        int base = 4; // Base for DNA alphabet size
        long hashS = 0, hashLWindow = 0;
        long power = (long) Math.pow(base, sLen - 1); // Most significant place value

        for (int i = 0; i < sLen; i++) {
            hashS = hashS * base + sNum[i];
            hashLWindow = hashLWindow * base + lNum[i];
        }

        int minHammingDistance = Integer.MAX_VALUE;

        // Initialize and check the first window
        minHammingDistance = Math.min(minHammingDistance, calculateHamming(sLen, sNum, lNum));

        // Slide over L and update hash values efficiently.
        for (int i = 1; i <= lLen - sLen; i++) {
            hashLWindow -= power * lNum[i - 1]; // Remove leading char
            hashLWindow *= base; // Shift left
            hashLWindow += lNum[i + sLen - 1]; // Add trailing char

            // If hashes match, it's a potential candidate for minimum Hamming distance.
            if (hashS == hashLWindow) {
                minHammingDistance = Math.min(minHammingDistance, calculateHamming(sLen, sNum, lNum));
            }
        }

        return minHammingDistance;
    }

    private static int charToNumber(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
            default: throw new IllegalArgumentException("Invalid DNA character: " + c);
        }
    }

    private static int calculateHamming(int sLen, int[] sNum, int[] lNum) {
        int hammingDistance = 0;
        for (int i = 0; i < sLen; i++) {
            if (sNum[i] != lNum[i]) {
                hammingDistance++;
            }
        }
        return hammingDistance;
    }

    public static void main(String[] args) {
        System.out.println(minHamming("ABCDEFGHIJ", "CDEFGG")); // Output: 1
        System.out.println(minHamming("ABCDEFGHIJ", "BCDGHI")); // Output: 3
    }
}