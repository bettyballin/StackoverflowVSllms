import java.lang.String;

public class UserEntityCreator {
    // Example of creating a user entity without writing raw SQL

    Session session = new Session();

    {
        User user = new User();
        user.setName("John Doe");
        session.save(user);
    }

    public static void main(String[] args) {
        new UserEntityCreator();
    }
}

class User {
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}

class Session {
    public void save(User user) {
        // Implementation for saving the user
    }
}