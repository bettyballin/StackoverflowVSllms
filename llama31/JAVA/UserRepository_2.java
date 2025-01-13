import org.junit.Test;
import static org.junit.Assert.assertEquals;

class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

public class UserRepository_2 {
    private java.util.List<User> users = new java.util.ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public java.util.List<User> getUsers() {
        return users;
    }

    public static class UserRepositoryTest {
        @Test
        public void testAddUser() {
            // Arrange
            User user = new User("John Doe", "johndoe@example.com");
            UserRepository repository = new UserRepository();

            // Act
            repository.addUser(user);

            // Assert
            assertEquals(1, repository.getUsers().size());
        }

        public static void main(String[] args) {
            org.junit.runner.JUnitCore.main("UserRepository.UserRepositoryTest");
        }
    }
}