import java.security.SecureRandom;
import java.util.UUID;

public class IdGenerator {
    private static final SecureRandom secureRandom = new SecureRandom();

    public static UUID generateId() {
        // Note: UUID.randomUUID() does not take any parameters, 
        // so we are just calling it without passing secureRandom.
        return UUID.randomUUID();
    }

    public static void main(String[] args) {
        // Example usage:
        UUID id = generateId();
        System.out.println("Generated ID: " + id);
    }
}