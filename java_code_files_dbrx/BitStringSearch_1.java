import java.util.List;
import java.util.ArrayList;

public class BitStringSearch_1 {
    public static void main(String[] args) {
        byte[] data = new byte[] {(byte) 0b10101000, (byte) 0b11100010, (byte) 0b01100001}; // Example binary array: 10101000 11100010 01100001
        BitStringSearch search = new BitStringSearch();
        List<String> matches = search.findBitStrings(data, "01", "100", "110");

        System.out.println("Matches: " + matches); // Output: Matches: [10, 1110]
    }
}

class BitStringSearch {
    public List<String> findBitStrings(byte[] data, String... patterns) {
        List<String> matches = new ArrayList<>();
        StringBuilder bitString = new StringBuilder();

        // Convert byte array to bit string
        for (byte b : data) {
            bitString.append(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));
        }

        // For each pattern, search in the bit string
        for (String pattern : patterns) {
            int index = bitString.indexOf(pattern);
            if (index != -1) {
                matches.add(pattern);
            }
        }

        return matches;
    }
}