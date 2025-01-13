import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// Define a User class
public class User_12 {
    private int id;
    private String name;
    private String email;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Hibernate session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Open a new session
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // Create a new user
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");

        // Save the user to the database
        session.save(user);

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}