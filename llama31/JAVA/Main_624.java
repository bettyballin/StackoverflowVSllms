import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.ArrayList;
import java.util.List;

// Mock implementation of AuthenticationManager for demonstration
class MockAuthenticationManager implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Mock authentication logic, always authenticates successfully for demo
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), authorities);
    }
}

public class Main_624 {
    public static void main(String[] args) {
        // Create a new authentication token
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("username", "password");

        // Get the authentication manager instance using our mock implementation
        AuthenticationManager authenticationManager = new MockAuthenticationManager();

        try {
            // Attempt to authenticate the user
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("Authenticated successfully.");
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}