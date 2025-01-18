import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.SecurityException;
import java.util.Date;
import javax.crypto.SecretKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyClass {

    private static final Logger logger = LoggerFactory.getLogger(MyClass.class);

    public String generateToken(String subject, Date expirationDate, SecretKey secretKey) {
        return Jwts.builder()
                .setSubject(subject) // user credentials information stored in the payload
                .setIssuedAt(new Date())
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String tokenString, SecretKey key) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(tokenString); // This will throw exceptions if it fails to parse or has an invalid signature.
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            logger.error("Invalid JWT token.", e);
        } catch (ExpiredJwtException ex) {
            logger.warn("JWT Token Expired", ex);
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported.", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty.", e);
        } // more catches as per your application needs.

        return false; // Ensure that the method returns false if an exception was thrown
    }
}