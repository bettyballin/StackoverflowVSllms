import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtAuth {
    private static final String SECRET_KEY = "your-secret-key-here"; // Ensure this key is stored securely

    public static String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 86400000); // 1 day validity
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY) // Use a stronger key management solution for production
                .compact();
    }

    public static String validateToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();  // Returns the username if valid, otherwise throws an exception
        } catch (Exception e) {
            return null;  // Token is invalid or expired
        }
    }

    public static void main(String[] args) {
        String token = generateToken("user-foo");
        System.out.println("Generated JWT: " + token);

        String username = validateToken(token);
        if (username != null)
            System.out.println("Validated username from token: " + username);
        else
            System.out.println("Token validation failed.");
    }
}