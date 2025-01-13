import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class Main_144 {
    public static void main(String[] args) {
        // Assuming token is a valid JWT token
        String token = "your_jwt_token_here";

        try {
            // Verify the JWT token
            JwtParser parser = Jwts.parser();
            Jws<Claims> jws = parser.parseClaimsJws(token);

            // Extract the user information
            String username = jws.getBody().getSubject();

            System.out.println("Username: " + username);
        } catch (Exception e) {
            System.out.println("An error occurred while parsing the JWT token: " + e.getMessage());
        }
    }
}