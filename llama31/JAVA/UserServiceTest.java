import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserById() {
        // Arrange
        User user = new User(1, "John Doe");
        when(userRepository.findById(1)).thenReturn(user);

        // Act
        User result = userService.getUserById(1);

        // Assert
        assertEquals(user, result);
        verify(userRepository).findById(1);
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("UserServiceTest");
    }
}