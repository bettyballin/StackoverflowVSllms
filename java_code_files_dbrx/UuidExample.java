import java.lang.String;
import java.util.UUID;

public class UuidExample {
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        System.out.println("Generated UUID: " + uuid);
    }
}