import java.util.UUID;
import java.rmi.server.UID;

public class Main {
    public static void main(String[] args) {
        try {
            // Generate a version 1 (time-based and includes the MAC address) UUID
            UID uid = new UID();
            UUID uuid = UUID.nameUUIDFromBytes(uid.toString().getBytes());
            System.out.println("Generated UUID: " + uuid);
        } catch (Exception ex) {
            // handle exception, maybe default to version 4 if this fails
            UUID uuid = UUID.randomUUID();
            System.out.println("Generated UUID (version 4): " + uuid);
        }
    }
}