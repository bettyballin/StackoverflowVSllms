import org.junit.Test;
import static org.junit.Assert.*;

// RegistrationFormTest.java

public class RegistrationFormTest {

    @Test
    public void testValidRegistration() {
        RegistrationForm form = new RegistrationForm();
        form.register(5); // Valid input
        // Assert successful registration...
    }

    @Test(expected = InvalidInputException.class)
    public void testInvalidRegistration() {
        RegistrationForm form = new RegistrationForm();
        form.register(15); // Invalid input
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("RegistrationFormTest");
    }
}

class RegistrationForm {
    public void register(int input) {
        if (input < 10) {
            // Valid input
        } else {
            throw new InvalidInputException();
        }
    }
}

class InvalidInputException extends RuntimeException {
}