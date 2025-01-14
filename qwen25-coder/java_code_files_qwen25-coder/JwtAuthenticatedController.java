import java.lang.String;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

public class JwtAuthenticatedController {
    // Example of a simple JWT-authenticated REST endpoint in Java with Spring Boot
    @GetMapping("/data")
    public ResponseEntity<String> getSecuredData(@RequestHeader("Authorization") String token) {
        // Validate the token
        if (!isValidToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        // Return data
        return ResponseEntity.ok("Secure Data");
    }

    private boolean isValidToken(String token) {
        // Simple token validation logic (placeholder for real implementation)
        return token != null && !token.isEmpty();
    }

    public static void main(String[] args) {
    }
}