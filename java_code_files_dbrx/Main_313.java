import java.time.Instant;
import java.time.Duration;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        OidcIdToken idToken = new OidcIdToken(
            "access_token",
            Instant.now(),
            Instant.now().plus(Duration.ofMinutes(5)),
            Map.of("email", "user@example.com")
        );
        // Add your own checks to verify the token, then use it for authorization and data access control
    }
}

class OidcIdToken {
    private String tokenValue;
    private Instant issuedAt;
    private Instant expiresAt;
    private Map<String, Object> claims;

    public OidcIdToken(String tokenValue, Instant issuedAt, Instant expiresAt, Map<String, Object> claims) {
        this.tokenValue = tokenValue;
        this.issuedAt = issuedAt;
        this.expiresAt = expiresAt;
        this.claims = claims;
    }

    // Add getters or other methods as needed
}