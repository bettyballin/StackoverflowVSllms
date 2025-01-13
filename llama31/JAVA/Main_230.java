import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_230 {
    public static void main(String[] args) {
        // Initialize your SessionFactory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Initialize your Session object
        Session rtsession = sessionFactory.getCurrentSession();

        // Initialize your first object
        Object userObj1 = new User("John", "Doe");

        // Initialize your second object
        Object userObj2 = new User("Jane", "Doe");

        // Start a transaction
        rtsession.beginTransaction();

        // Merge the first object
        rtsession.merge(userObj1);

        // Merge the second object
        rtsession.merge(userObj2);

        // Commit the transaction
        rtsession.getTransaction().commit();

        // Close the session
        rtsession.close();

        // Close the sessionFactory
        sessionFactory.close();
    }
}

// Example User class
class User {
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}