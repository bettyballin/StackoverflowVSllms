import java.lang.String;
import java.util.UUID;

public class GenerateUUID {
    public static void main(String[] args) {
        // Generating a random UUID
        UUID uuid = UUID.randomUUID();
        System.out.println("Generated GUID: " + uuid.toString());
    }
}