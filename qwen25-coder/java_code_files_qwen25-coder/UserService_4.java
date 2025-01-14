// Example of modular architecture in Java
public class UserService_4 {
    private static final DatabaseConnector connector = new DatabaseConnector();

    public User getUserById(int id) {
        return connector.getUserFromDatabase(id);
    }

    public static void main(String[] args) {
        UserService_4 service = new UserService_4();
        User user = service.getUserById(1);
        System.out.println("User retrieved: " + user);
    }
}

class User {
    // User properties and methods can be added here
    @Override
    public String toString() {
        return "User object";
    }
}

class DatabaseConnector {
    public User getUserFromDatabase(int id) {
        // Simulate database access
        return new User();
    }
}