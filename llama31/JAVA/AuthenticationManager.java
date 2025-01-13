import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class AuthenticationManager {
    public boolean authenticate(String username, String password) {
        // authentication logic
        // For demonstration purposes, assume "validUser" and "validPassword" are valid credentials
        return username.equals("validUser") && password.equals("validPassword");
    }
}

public class AuthenticationManagerTest {
    @Test
    public void testAuthenticateValidCredentials() {
        AuthenticationManager authManager = new AuthenticationManager();
        boolean result = authManager.authenticate("validUser", "validPassword");
        assertTrue(result);
    }

    @Test
    public void testAuthenticateInvalidCredentials() {
        AuthenticationManager authManager = new AuthenticationManager();
        boolean result = authManager.authenticate("invalidUser", "invalidPassword");
        assertFalse(result);
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("AuthenticationManagerTest");
    }
}