public class UserServiceTest {

    public static void main(String[] args) {
        UserServiceTest test = new UserServiceTest();
        test.testGetUserEmail();
    }

    public void testGetUserEmail() {
        // Create a mock of the dependency
        UserDatabase mockDatabase = new UserDatabase() {
            public User getUser(int userId) {
                if (userId == 1) {
                    return new User("test@example.com");
                } else {
                    return null;
                }
            }
        };

        // Inject the mock into the class under test
        UserService userService = new UserService(mockDatabase);

        // Perform the test
        if (!"test@example.com".equals(userService.getUserEmail(1))) {
            throw new AssertionError("Expected 'test@example.com', but got '" + userService.getUserEmail(1) + "'");
        } else {
            System.out.println("Test passed");
        }
    }
}

// Assume this is the class under test
class UserService {
    private final UserDatabase database;

    public UserService(UserDatabase database) {
        this.database = database;
    }

    public String getUserEmail(int userId) {
        User user = database.getUser(userId);
        if (user != null) {
            return user.getEmail();
        } else {
            return null;
        }
    }
}

class User {
    private String email;

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}

interface UserDatabase {
    User getUser(int userId);
}