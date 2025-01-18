import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Example {
    public static void main(String[] args) {
        // Create a SessionFactory (assuming hibernate.cfg.xml is properly configured)
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Obtain a Session
        Session session = sessionFactory.openSession();

        // Begin transaction
        Transaction tx = session.beginTransaction();

        // Set flush mode
        session.setFlushMode(FlushMode.ALWAYS);  // Enforce automatic flushing

        // Your code here...

        // Commit the transaction
        tx.commit();

        // Close the session
        session.close();
        sessionFactory.close();
    }
}