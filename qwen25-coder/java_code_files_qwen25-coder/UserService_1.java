import java.util.ArrayList;
import java.util.List;

class User {
    private String name;

    // Constructor
    public User(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }
}

public class UserService {
    public List<User> searchUsers(String query) {
        // Basic implementation for demonstration purposes
        return new ArrayList<>();
    }
}