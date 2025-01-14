import java.lang.String;
import java.security.SecureRandom;

public class UniqueIDGenerator_1 {
    private static final SecureRandom secureRandom = new SecureRandom();

    public static long getUniqueID() {
        // Define how many bits you want from timestamp and random part
        int bitsFromTimestamp = 40;
        int bitsFromRandom = 24; // Total should be 64 (40 + 24)

        // Get the current timestamp in milliseconds
        long timestamp = System.currentTimeMillis();

        // Create a random number for combined ID
        long randomPart = secureRandom.nextLong() & ((1L << bitsFromRandom) - 1);

        // Mask and shift to create final ID
        long id = (timestamp << (64 - bitsFromTimestamp)) | randomPart;

        return id;
    }

    public static void main(String[] args) {
        System.out.println("Unique ID: " + getUniqueID());
    }
}