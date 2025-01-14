import java.security.SecureRandom;
import javax.servlet.http.HttpSession;

public class ApiTokenGenerator {
    public String generateApiToken(HttpSession session) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(Integer.toString((b & 0xff) + 0x100, 36).substring(1));
        }
        String token = sb.toString().substring(0, 32); // Use first 32 characters
        session.setAttribute("apiToken", token);
        return token;
    }
}