import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

// Automated testing with JUnit
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest_2_2 {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUsers() {
        // Arrange

        // Act
        List<User> users = userService.getUsers();

        // Assert
        assertNotNull(users);
    }

    public static void main(String[] args) {
    }
}