import java.util.List;

public class UserServiceManager {
    public interface UserService {
        List<User> getAllUsers();
        User getUserById(int userId);
        boolean saveUser(User user);
        boolean deleteUser(int userId);
    }

    public static void main(String[] args) {
    }
}

class User {
    // Minimal implementation to allow code to compile
}