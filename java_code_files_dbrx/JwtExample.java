import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.SignatureAlgorithm;
import java.nio.charset.StandardCharsets;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class JwtExample {

    public static void main(String[] args) {
        // Example using JWT for secure transmission of SessionID between servers

        // Assuming sessionId and secretKey are defined
        String sessionId = "yourSessionId";  // Replace with actual session ID
        String secretKey = "yourSecretKey";  // Replace with your secret key

        JwtBuilder builder = Jwts.builder()
                            .setSubject(sessionId);  // unique session ID
                            // Add more claims as required (issuer, expiration time etc.)
                            // For example:
                            // .setIssuer("yourIssuer")
                            // .setExpiration(new Date(System.currentTimeMillis() + 3600000)); // 1 hour expiration

        // Create HMAC key
        Key hmacKey = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), 
                            SignatureAlgorithm.HS256.getJcaName());

        String compactJws = builder.signWith(hmacKey).compact();

        String url = "https://javaServer/form.jsp?token=" + compactJws;

        System.out.println(url);
    }
}