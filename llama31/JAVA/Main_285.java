import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

// Assuming Test and TestExtension classes are defined elsewhere
class Test {}
class TestExtension {}

public class Main_285 {
    public static void main(String[] args) {
        // Create a Hibernate session factory
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // Assuming a hibernate.cfg.xml file exists
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        // Create a Hibernate session
        Session session = sessionFactory.openSession();

        // Create the query
        Query query = session.createQuery("SELECT t, te FROM Test t LEFT JOIN t.testExtension te WHERE t.testId = :testId");

        // Set the testId parameter
        Long testId = 123L; // replace with the actual testId
        query.setParameter("testId", testId);

        // Execute the query and get the results
        List<Object[]> results = query.list();

        // Process the results
        for (Object[] result : results) {
            Test test = (Test) result[0];
            TestExtension testExtension = (TestExtension) result[1];
            // ... process the test and testExtension objects
        }

        // Close the session and session factory
        session.close();
        sessionFactory.close();
    }
}