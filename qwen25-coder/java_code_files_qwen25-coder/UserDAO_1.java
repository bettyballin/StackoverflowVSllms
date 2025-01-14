import java.lang.String;
import net.java.ao.EntityManager;
import net.java.ao.DBParam;
import net.java.ao.Query;
import net.java.ao.Entity;

public class UserDAO {
    private final EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User addUser(String username, String email) {
        return entityManager.create(User.class,
                new DBParam("username", username),
                new DBParam("email", email));
    }

    public User getUserByUsername(String username) {
        User[] users = entityManager.find(User.class, Query.select().where("username = ?", username));
        if (users.length > 0) {
            return users[0];
        }
        return null;
    }

    public static void main(String[] args) {
    }
}

interface User extends Entity {
    String getUsername();
    void setUsername(String username);

    String getEmail();
    void setEmail(String email);
}