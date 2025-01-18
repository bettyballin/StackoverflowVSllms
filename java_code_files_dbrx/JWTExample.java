import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class JWTExample {
    private static final String SECRET_KEY = "secretKey";

    public String createToken(Long userId) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setId("" + userId) // unique user ID for this sample application
                .setIssuedAt(now)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256);

        if (userId == 1L) {  // Sample for super role :
            builder.claim("roles", Arrays.asList("ROLE_ADMIN", "ROLE_USER"));
        } else {     // All other users are treated as a normal USER ROLE :
            builder.claim("roles", Collections.singletonList("ROLE_USER"));
        }

        return builder.compact();   // Build and emit the JWT
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}