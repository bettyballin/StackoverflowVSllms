import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest_1_1 {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUser() {
        User user = new User("John Doe");
        when(userRepository.findById(1)).thenReturn(user);
        assertEquals(user, userService.getUser(1));
    }

    public static void main(String[] args) {
    }
}