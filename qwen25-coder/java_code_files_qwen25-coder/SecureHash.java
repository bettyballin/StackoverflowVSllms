import java.lang.String;
import java.lang.Integer;
// Example of using a more secure hash function in Java
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecureHash {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "mySecurePassword";
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(password.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : encodedhash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        System.out.println("SHA-256 Hash: " + hexString.toString());
    }
}