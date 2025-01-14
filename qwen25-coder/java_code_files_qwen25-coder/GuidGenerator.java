import java.lang.String;
import java.util.UUID;

public class GuidGenerator {
    public static void main(String[] args) {
        // Generate a new UUID
        UUID uuid = UUID.randomUUID();
        
        // Convert the UUID to a string representation compatible with SQL Server's uniqueidentifier
        String guidString = uuid.toString().toUpperCase();
        
        System.out.println("Generated GUID: " + guidString);
    }
}