// Define the User class
class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Good example
public interface UserRepository {
    User getUser(int id);
}

public class MySQLUserRepository implements UserRepository {
    // Simple implementation for demonstration purposes
    @Override
    public User getUser(int id) {
        // In a real implementation, you'd retrieve the user from the database
        // For this example, we'll just return a hardcoded user
        return new User(id, "John Doe");
    }

    public static void main(String[] args) {
        MySQLUserRepository repository = new MySQLUserRepository();
        User user = repository.getUser(1);
        System.out.println("User ID: " + user.getId());
        System.out.println("User Name: " + user.getName());
    }
}