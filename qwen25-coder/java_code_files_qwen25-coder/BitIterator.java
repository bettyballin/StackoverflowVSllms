import java.lang.String;
public class BitIterator {
    public static void main(String[] args) {
        byte[] byteArray = { (byte) 0b10101010, (byte) 0b01010101 };

        for (byte b : byteArray) {
            for (int i = 7; i >= 0; i--) {
                // Shift the bit in position i to the least significant bit and mask with 1
                int bit = (b >> i) & 1;
                System.out.print(bit);
            }
            System.out.println(); // New line after each byte
        }
    }
}