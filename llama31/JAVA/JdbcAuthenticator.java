import java.security.Principal;
import java.security.auth.login.FailedLoginException;

// Assuming jdbcRealm and GenericPrincipal are defined elsewhere
// You may need to import or define these classes

public class JdbcAuthenticator extends Authenticator { // Authenticator is assumed to be the superclass
    @Override
    public Principal authenticate(String username, String credentials) {
        Principal principal = super.authenticate(username, credentials);
        if (principal != null) {
            // Retrieve roles from database
            String[] roles = jdbcRealm.getRoles(principal.getName());
            // Create a new Principal with the roles
            principal = new GenericPrincipal(principal.getName(), credentials, roles, principal.getUser());
        }
        return principal;
    }

    public static void main(String[] args) {
        // Empty main method, you may want to add some code here
    }
}