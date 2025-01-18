import java.util.List;

public class UserDAODataAccessObject {
    public interface UserService {
        List<User> fetchUsers();
        User fetchUser(int userId);
        boolean saveUser(User user);
        boolean deleteUser(int userId);
    }

    public static void main(String[] args) {
    }

    public class User {
        // Minimal User class definition to enable compilation
    }
}