import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// UserDAO.java
class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public User getUserById(int id) {
        // Query the database using the connection
        return new User(); // For the sake of compilation
    }
}

class User {}

// UserDAOTest.java
@RunWith(MockitoJUnitRunner.class)
public class UserDAO_2_2Test {
    @Mock
    private Connection connection;

    @InjectMocks
    private UserDAO userDAO;

    @Test
    public void testGetUserById() {
        // Mock the database response
        when(connection.prepareStatement(anyString())).thenReturn(mock(PreparedStatement.class));

        // Call the method under test
        User user = userDAO.getUserById(1);

        // Verify the result
        assertNotNull(user);
    }

    public static void main(String[] args) {
    }
}