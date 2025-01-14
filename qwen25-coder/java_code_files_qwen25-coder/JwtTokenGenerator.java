import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtTokenGenerator {
    // Example in Java using JWT with a short expiry time
    String username = "username";
    String token = Jwts.builder()
         .setSubject(username)
         .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 1 hour
         .signWith(SignatureAlgorithm.HS512, "secret")
         .compact();

    public static void main(String[] args) {
    }
}