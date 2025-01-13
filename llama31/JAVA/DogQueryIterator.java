import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DogQueryIterator {
    public static void main(String[] args) {
        // Create a Hibernate session factory
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        // Create a session
        Session session = sessionFactory.openSession();

        // Your original code
        Query query = session.createQuery("FROM Dog WHERE ...");
        ScrollableResults results = query.scroll();
        int rownum = 0;
        while (results.next()) {
            rownum++;
            Dog dog = (Dog) results.get(0);
            // do something with dog and rownum
        }

        // Close the session
        session.close();
        sessionFactory.close();
    }
}