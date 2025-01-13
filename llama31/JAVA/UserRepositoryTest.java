import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserRepositoryTest {

    private UserRepository userRepository = new UserRepository();

    @Test
    public void testAddUser() {
        // Arrange
        User user = new User("John Doe", "john.doe@example.com");

        // Act
        userRepository.addUser(user);

        // Assert
        assertEquals(1, userRepository.getUsers().size());
    }

    public static void main(String[] args) {
    }
}

class UserRepository {
    private java.util.List<User> users = new java.util.ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public java.util.List<User> getUsers() {
        return users;
    }
}

class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}