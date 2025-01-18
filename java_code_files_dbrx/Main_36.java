import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;

public class Main {
    public static void main(String[] args) throws Exception {
        String secret = "password"; // this should come from a secure place, never hardcoded!
        byte[] saltValueBytes = new byte[]{1, 2, 3, 4, 5, 6, 7, 8}; // your salt here
        int derivedKeyLength = 16; // key length, in bytes

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(secret.toCharArray(), saltValueBytes, 100000, derivedKeyLength * 8); // iterationCount and key size must be in bits for SunJCE provider, not bytes!
        SecretKey tmp = factory.generateSecret(spec);
        byte[] secretKey = tmp.getEncoded();
        
        // Optionally, print the generated key in hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (byte b : secretKey) {
            sb.append(String.format("%02x", b));
        }
        System.out.println("Derived Key: " + sb.toString());
    }
}