import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

public class RoleBasedAccessController {
    public static void main(String[] args) {
        // Restrict access to sensitive data based on roles
        if (SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("SUPPORT"))) {
            // Allow access to limited data and features for support personnel
            System.out.println("Access granted for support personnel.");
        } else {
            // Deny access to sensitive data and features
            System.out.println("Access denied.");
        }
    }
}