// Import necessary libraries
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

public class JwtExample {

    // Secret key used to sign the token
    private static final String SECRET = "your-256-bit-secret";

    public static void main(String[] args) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            
            // Generate a new JWT token
            String token = JWT.create()
                .withIssuer("your-app")
                .withSubject("exampleUser") // Set the subject claim
                .sign(algorithm);

            System.out.println(token);

            // Validate the JWT token
            boolean isValid = JWT.require(algorithm)
                                 .withIssuer("your-app")
                                 .build()
                                 .verify(token)
                                 .getSubject()
                                 .equals("exampleUser");

            System.out.println("Token is valid: " + isValid);
            
        } catch (JWTCreationException exception) {
            // Invalid Signing configuration / Couldn't convert Claims.
            throw new RuntimeException(exception.getMessage());
        } catch (JWTVerificationException exception) {
            // Invalid signature/claims
            throw new RuntimeException(exception.getMessage());
        }
    }
}