import java.lang.String;

@RunWith(JUnitQuickcheck.class)
public class QuickCheckExample {

    @Property(trials = 100)
    public void testLoginWithRandomCredentials(String username, String password) {
        // Create a system under test
        AuthenticationSystem authSystem = new AuthenticationSystem();

        // Assuming that login fails for all invalid credentials
        boolean isAuthenticated = authSystem.login(username, password);

        // Check if login fails as expected for random inputs
        assert !isAuthenticated : "Login should fail for random or invalid credentials";
    }

    public static void main(String[] args) {
    }
}

// Minimal definition of the AuthenticationSystem class
class AuthenticationSystem {
    public boolean login(String username, String password) {
        // Minimal implementation, assuming login fails for all inputs
        return false;
    }
}

// Minimal definition of the RunWith annotation
@interface RunWith {
    Class<?> value();
}

// Minimal definition of the Property annotation
@interface Property {
    int trials() default 100;
}

// Minimal definition of the JUnitQuickcheck class
class JUnitQuickcheck {
    // Empty class, serves as a placeholder for the annotation
}