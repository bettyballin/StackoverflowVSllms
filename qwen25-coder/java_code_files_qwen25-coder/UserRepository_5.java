import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Example of a hybrid DAO implementation

public class UserRepository_5 {

    private SessionFactory sessionFactory;
    private Connection connection; // JDBC connection setup here

    public User getUserById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    public List<User> getUsersByAge(int age) {
        String sql = "SELECT * FROM users WHERE age > ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, age);
            ResultSet rs = stmt.executeQuery();
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
    }
}

class User {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

interface SessionFactory {
    Session openSession();
}

interface Session extends AutoCloseable {
    <T> T get(Class<T> clazz, int id);

    @Override
    void close();
}