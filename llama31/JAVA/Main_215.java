import java.security.SecureRandom;
import java.util.UUID;

public class Main_215 {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
    }
}