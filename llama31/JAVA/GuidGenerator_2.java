import java.lang.String;
import java.util.UUID;

public class GuidGenerator_2 {
    public static String generateGuidWithPrefix(String prefix) {
        // Generate a random UUID
        UUID randomUuid = UUID.randomUUID();
        
        // Convert the UUID to a string
        String uuidStr = randomUuid.toString();
        
        // Replace the first 8 characters with the prefix
        String guidWithPrefix = prefix + uuidStr.substring(8);
        
        return guidWithPrefix;
    }

    public static void main(String[] args) {
        String prefix = "MY_PREFIX";
        String guid = generateGuidWithPrefix(prefix);
        System.out.println(guid);
    }
}