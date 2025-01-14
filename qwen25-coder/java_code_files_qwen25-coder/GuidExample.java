import java.lang.String;
import java.util.UUID;

public class GuidExample {
    public static void main(String[] args) {
        UUID guid = UUID.randomUUID();
        System.out.println("Generated GUID: " + guid.toString());
    }
}