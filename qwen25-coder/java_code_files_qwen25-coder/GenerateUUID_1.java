import java.lang.String;
import java.util.UUID;

public class GenerateUUID_1 {
    public static void main(String[] args) {
        UUID uniqueID = UUID.randomUUID();
        System.out.println("Generated GUID: " + uniqueID.toString());
    }
}