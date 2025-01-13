import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

public class AuthenticatedUserTest {
    @Test
    @WithMockUser(username = "testUser", password = "testPassword")
    public void testAuthenticatedUser() {
        // Your test code here
    }

    public static void main(String[] args) {
    }
}