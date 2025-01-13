import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class UserDAO_14_14 {
    public static void main(String[] args) {
        // Create a configuration instance
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Create a service registry
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        // Create a session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        // Create a session
        Session session = sessionFactory.openSession();

        // Get the user
        User user = session.get(User.class, 1L); // hits the database immediately

        // Close the session
        session.close();
    }
}