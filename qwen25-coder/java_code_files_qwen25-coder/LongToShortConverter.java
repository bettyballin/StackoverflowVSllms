import java.lang.String;
public class LongToShortConverter {
    public static void main(String[] args) {
        long timestampLong = System.currentTimeMillis(); // Example 64-bit timestamp

        // Convert to short (16 bits)
        short timestampShort = (short) timestampLong;

        System.out.println("Original Timestamp: " + timestampLong);
        System.out.println("Truncated Timestamp: " + timestampShort);
    }
}