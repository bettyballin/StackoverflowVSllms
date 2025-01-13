import org.junit.Test;
import static org.junit.Assert.fail;

public class LoginServiceTest {
    // Turkey Test example: checking if a login form can handle a username with an unexpected character
    @Test
    public void testTurkeyTest() {
        String unusualUsername = "John&Doe!"; // unexpected character: '&'
        LoginService loginService = new LoginService();
        try {
            loginService.login(unusualUsername, "password");
            fail("Expected exception not thrown");
        } catch (InvalidUsernameException e) {
            // expected exception thrown, test passes
        }
    }
    public static void main(String[] args) {
    }
}

class LoginService {
    public void login(String username, String password) throws InvalidUsernameException {
        // Implement your login logic here
        if (username.contains("&")) {
            throw new InvalidUsernameException("Invalid username");
        }
    }
}

class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String message) {
        super(message);
    }
}