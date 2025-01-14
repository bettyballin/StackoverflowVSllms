import java.lang.String;
import java.lang.Integer;
public class CRC32Example {
    public static void main(String[] args) {
        // Example input data
        byte[] data = { (byte) 0xFF, (byte) 0xFE, (byte) 0xFD }; // Simulating unsigned chars

        int crc = calculateCRC32(data);
        System.out.println("Calculated CRC: " + Integer.toHexString(crc));
    }

    public static int calculateCRC32(byte[] data) {
        int crc = 0xFFFFFFFF; // Initial value
        for (byte b : data) {
            // Treat the byte as unsigned by & with 0xFF
            int bb = b & 0xFF;
            for (int i = 7; i >= 0; i--) {
                boolean bit = ((bb >> i) & 1) == 1;
                if (crc < 0 ^ bit) {
                    crc = crc * 2 ^ 0xEDB88320;
                } else {
                    crc = crc * 2;
                }
            }
        }
        return ~crc;
    }
}