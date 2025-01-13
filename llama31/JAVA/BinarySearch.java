import java.lang.String;
import java.lang.Integer;
public class BinarySearch {
    public static int findMatch(byte[] data, int[] codes) {
        int dataIndex = 0;
        int bitIndex = 0;
        int codeIndex = 0;

        for (int code : codes) {
            int codeLength = Integer.SIZE - Integer.numberOfLeadingZeros(code);

            // Load the next 'codeLength' bits from the data
            int bits = 0;
            while (codeLength > 0) {
                int remainingBitsInByte = 8 - bitIndex;
                int bitsToLoad = Math.min(remainingBitsInByte, codeLength);

                int mask = (1 << bitsToLoad) - 1;
                bits |= ((data[dataIndex] >>> (8 - bitIndex - bitsToLoad)) & mask) << (codeLength - bitsToLoad);

                codeLength -= bitsToLoad;
                bitIndex += bitsToLoad;

                if (bitIndex == 8) {
                    dataIndex++;
                    bitIndex = 0;
                }
            }

            if (bits == code) {
                return codeIndex;
            }

            codeIndex++;
        }

        return -1; // No match found
    }

    public static void main(String[] args) {
        byte[] data = {(byte) 0b10101000, (byte) 0b11100010, (byte) 0b01100001, (byte) 0b01010111, (byte) 0b01110001, (byte) 0b01010110};
        int[] codes = {0b1010, 0b100, 0b110, 0b1110};

        int matchIndex = findMatch(data, codes);
        if (matchIndex != -1) {
            System.out.println("Match found at index " + matchIndex);
        } else {
            System.out.println("No match found");
        }
    }
}