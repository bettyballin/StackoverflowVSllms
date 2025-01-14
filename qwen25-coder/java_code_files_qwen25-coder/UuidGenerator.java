import java.lang.String;
import java.util.UUID;

public class UuidGenerator {
    public static void main(String[] args) {
        UUID randomUUID = UUID.randomUUID();
        System.out.println("Generated UUID: " + randomUUID);
    }
}