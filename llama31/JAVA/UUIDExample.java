import java.lang.String;
import java.util.UUID;

public class UUIDExample {
    public static void main(String[] args) {
        // Generate a random UUID
        UUID randomUUID = UUID.randomUUID();

        // Convert UUID to a 36-character hexadecimal string with hyphens
        String uuidWithHyphens = randomUUID.toString();

        // Remove hyphens to get a 32-character hexadecimal string
        String compactUUID = uuidWithHyphens.replace("-", "");

        System.out.println("UUID with hyphens: " + uuidWithHyphens);
        System.out.println("Compact UUID: " + compactUUID);
    }
}