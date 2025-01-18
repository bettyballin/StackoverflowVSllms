import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public final class TestSecurityUtils {
    private static String testUser = "username";
    private static String testPassword = "password";

    public static void authenticate() {
        UsernamePasswordAuthenticationToken authRequest = getAuthentication(testUser, testPassword);
        SecurityContextHolder.getContext().setAuthentication(authRequest);
    }

    private static Authentication getAuthentication(String username, String password) {
        return new UsernamePasswordAuthenticationToken(username, password);
    }

    public static void main(String[] args) {
        authenticate();
    }
}