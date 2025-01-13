import org.junit.Test;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class SecurePasswordEncoderTest {
    @Test
    public void testPasswordHashing() {
        String password = "mysecretpassword";
        String hashedPassword = SecurePasswordEncoder.hashPassword(password);
        assertNotEquals(password, hashedPassword);
    }

    @Test
    public void testPasswordVerification() {
        String password = "mysecretpassword";
        String hashedPassword = SecurePasswordEncoder.hashPassword(password);
        assertTrue(SecurePasswordEncoder.verifyPassword(password, hashedPassword));
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("SecurePasswordEncoderTest");
    }
}