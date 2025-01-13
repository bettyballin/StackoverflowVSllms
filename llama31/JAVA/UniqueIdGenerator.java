import java.lang.String;
import java.util.UUID;

public class UniqueIdGenerator {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println(generateId());
    }
}