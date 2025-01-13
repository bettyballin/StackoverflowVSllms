import net.java.ao.Entity;
import net.java.ao.EntityManager;
import net.java.ao.Preload;
import net.java.ao.Query;

// Define your entity
@Entity
@Preload
public interface User {
    String getName();
    void setName(String name);
    String getPassword();
    void setPassword(String password);
}

public class Main_699 {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManager.create("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

        // Use prepared statements to retrieve data
        Query query = Query.select("name", "password").where("name = ?", "JohnDoe");
        User user = entityManager.find(User.class, query);

        System.out.println(user.getName());
        System.out.println(user.getPassword());
    }
}