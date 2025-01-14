import java.lang.String;
import java.util.UUID;

public class SessionIDGenerator {
    public static String generateSessionID() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println(generateSessionID());
    }
}