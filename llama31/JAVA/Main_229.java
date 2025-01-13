// Import necessary libraries
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main_229 {
    public static void main(String[] args) {
        // Create a configuration object
        Configuration cfg = new Configuration();

        // Create a session factory
        SessionFactory sessionFactory = cfg.configure().buildSessionFactory();

        // Create a session
        Session rtsession = sessionFactory.openSession();

        // Begin a transaction
        Transaction tx = rtsession.beginTransaction();

        // Assuming userObj1 and userObj2 are already created and populated
        // Save the first object
        // Object userObj1 = new Object(); // You need to create userObj1
        // rtsession.save(userObj1);

        // Clear the session
        rtsession.clear();

        // Save the second object
        // Object userObj2 = new Object(); // You need to create userObj2
        // rtsession.save(userObj2);

        // Commit the transaction
        tx.commit();

        // Close the session
        rtsession.close();

        // Close the session factory
        sessionFactory.close();
    }
}