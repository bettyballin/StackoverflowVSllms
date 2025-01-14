import java.lang.String;
import java.util.UUID;

public class UniqueIdentifier {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println("Generated UUID: " + uuid);
    }
}