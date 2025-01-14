import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Base64;

public class SessionTokenGenerator {
    // Pseudo-code for generating and passing token
    String generateSessionToken(String username) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(new Date());
        String secretKey = "YourSharedSecret";
        return Base64.getEncoder().encodeToString((username + timestamp + secretKey).getBytes());
    }
    public static void main(String[] args) {
    }
}