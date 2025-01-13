import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class UserValidatorTest {
    @Test
    public void testValidUsername() {
        String username = "johnDoe";
        UserValidator validator = new UserValidator();
        assertTrue(validator.isValidUsername(username));
    }

    @Test
    public void testInvalidUsername() {
        String username = " invalid!";
        UserValidator validator = new UserValidator();
        assertFalse(validator.isValidUsername(username));
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("UserValidatorTest");
    }
}

class UserValidator {
    public boolean isValidUsername(String username) {
        // Simple validation, you should adjust this according to your needs
        return username.matches("[a-zA-Z0-9]+");
    }
}