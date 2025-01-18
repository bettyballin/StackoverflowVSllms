import java.util.ArrayList;
import java.util.List;

public class BitStringSearch {
    private static final int MAX_BIT_STRING_LENGTH = 16; // Maximum length of bit strings

    public List<String> findBitStrings(byte[] data, String... patterns) {
        List<String> matches = new ArrayList<>();
        for (byte b : data) {
            for (int shift = MAX_BIT_STRING_LENGTH - 1; shift >= 0; shift--) {
                int mask = (1 << (MAX_BIT_STRING_LENGTH - shift)) - 1; // Create a bitmask
                int value = ((b & 0xFF) >>> shift) & mask; // Apply the mask and get the target bits
                String binaryString = Integer.toBinaryString(value);

                for (String pattern : patterns) {
                    if (!binaryString.startsWith(pattern)) continue;

                    matches.add(binaryString);
                }
            }
        }
        return matches;
    }

    public static void main(String[] args) {
    }
}