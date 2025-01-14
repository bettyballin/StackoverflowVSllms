import java.lang.String;
import java.util.UUID;
import java.util.Base64;

public class UUIDToBase64 {
    public static void main(String[] args) {
        // Generate a random UUID
        UUID uuid = UUID.randomUUID();
        
        // Convert the UUID to bytes and then to a Base64 string
        byte[] uuidBytes = new byte[16];
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        for (int i = 0; i < 8; i++) {
            uuidBytes[i] = (byte) (mostSignificantBits >>> (8 * (7 - i)));
        }
        for (int i = 8; i < 16; i++) {
            uuidBytes[i] = (byte) (leastSignificantBits >>> (8 * (15 - i)));
        }
        
        String base64Uuid = Base64.getUrlEncoder().withoutPadding().encodeToString(uuidBytes);
        System.out.println("Base64 encoded UUID: " + base64Uuid);
    }
}