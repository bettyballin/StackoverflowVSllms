import java.lang.String;
import java.lang.Integer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecureHashExample {
    public static String hashWithSHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String originalString = "Secure Hash Example";
        System.out.println("Original: " + originalString);
        System.out.println("SHA-256 hash: " + hashWithSHA256(originalString));
    }
}