import java.lang.String;
import java.lang.Integer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository_1 {

    class UserRepository {
        private final Map<Integer, User> users;

        public UserRepository() {
            this.users = new ConcurrentHashMap<>();
        }

        public void addUser(User user) {
            users.put(user.getId(), user);
        }

        public void updateUser(int userId, User updatedUser) {
            users.replace(userId, updatedUser);
        }

        public User getUserById(int id) {
            return users.get(id);
        }

        // Additional query methods can be implemented here
    }

    public static void main(String[] args) {
        // Entry point of the program
    }
}

class User {
    private int id;
    // other fields can be added here

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // other methods can be added here
}