import java.util.List;
// Example in Java using JUnit and Mockito
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void testUserSearch() {
        UserService userService = new UserService();
        List<User> users = userService.searchUsers("John");
        assertFalse(users.isEmpty());
    }

    public static void main(String[] args) {
    }
}