import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;

public class None_15_15 {
    public static String encrypt(String encrypted, String salt) {
        // You need to implement your encryption logic here
        return encrypted + salt;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String encrypted = "your_encrypted_string";
        String salt = "your_salt";
        String encryptedResult = encrypt(encrypted, salt);
        String encoded = URLEncoder.encode(Base64.getEncoder().encodeToString(encryptedResult.getBytes(StandardCharsets.UTF_8)), "UTF-8");
        System.out.println(encoded);
    }
}