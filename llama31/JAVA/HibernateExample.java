import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExample {
    public static void main(String[] args) {
        // Create a Hibernate configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // Create a SessionFactory
        SessionFactory sf = cfg.buildSessionFactory();

        // Create a Session
        Session session = sf.openSession();

        // Perform CRUD operations using Hibernate's API
        // ...

        // Close the Session and SessionFactory
        session.close();
        sf.close();
    }
}