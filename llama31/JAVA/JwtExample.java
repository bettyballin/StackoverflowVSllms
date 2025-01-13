import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtExample {
    private static final String secretKey = "your_secret_key_here"; // Replace with your secret key

    public static void main(String[] args) {
        // Generate a JWT token
        JwtBuilder builder = Jwts.builder();
        builder.setSubject("username");
        builder.setExpiration(System.currentTimeMillis() + 3600000); // 1 hour
        builder.signWith(SignatureAlgorithm.HS256, secretKey); // Specify the signature algorithm and secret key
        String token = builder.compact();

        // Verify the JWT token
        try {
            Jws<Claims> jws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            String username = jws.getBody().getSubject();
            System.out.println("Username: " + username);
            // Use the username to authenticate and authorize
        } catch (JwtException e) {
            System.out.println("Invalid or expired token");
            // Handle invalid or expired token
        }
    }
}