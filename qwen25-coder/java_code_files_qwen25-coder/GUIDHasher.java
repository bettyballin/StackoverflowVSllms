import java.lang.String;
import java.lang.Integer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class GUIDHasher {
    public static void main(String[] args) {
        String guid = UUID.randomUUID().toString();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(guid.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            System.out.println("GUID: " + guid);
            System.out.println("SHA-256 Hash: " + hexString.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}