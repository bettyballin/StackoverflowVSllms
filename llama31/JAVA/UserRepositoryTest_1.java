import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

// UserRepositoryTest.java
@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest_1_1 {

    @Mock
    private UserRepository userRepository;

    @Test
    public void testGetUserById() {
        Long id = 1L;
        User expectedUser = new User(id, "John Doe");

        when(userRepository.getUserById(id)).thenReturn(expectedUser);

        User actualUser = userRepository.getUserById(id);
        assertEquals(expectedUser, actualUser);
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("UserRepositoryTest_1");
    }
}