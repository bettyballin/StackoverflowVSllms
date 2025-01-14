import java.lang.String;
import java.util.UUID;

public class GenerateGuid {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println("Generated GUID: " + uuid);
    }
}