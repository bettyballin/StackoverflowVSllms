import java.lang.String;
import java.util.Random;
import java.util.UUID;

public class CustomPrefixUUID {
    public static void main(String[] args) {
        String prefix = "1234567"; // Your custom prefix here (max 8 characters for this example)
        
        UUID uuid = generateCustomPrefixUUID(prefix);
        System.out.println("Generated UUID: " + uuid.toString());
    }

    private static UUID generateCustomPrefixUUID(String prefix) {
        if (prefix.length() > 8) {
            throw new IllegalArgumentException("Prefix should be up to 8 characters long.");
        }
        
        // Fill the remaining part of the first block with random numbers
        Random random = new Random();
        long msb = parseHexWithZeros(prefix) << 32; // Shift left to ensure prefix is in the most significant bits
        msb |= (random.nextLong() & 0xFFFFFFFFL);      // Append a random number to complete the first part of UUID
        
        // Generate second part of UUID, can be random as per UUID version 4
        long lsb = random.nextLong();
        
        return new UUID(msb, lsb);
    }

    private static long parseHexWithZeros(String hex) {
        return Long.parseLong(hex + "0".repeat(8 - hex.length()), 16);
    }
}