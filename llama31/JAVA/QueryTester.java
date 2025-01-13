import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;
import java.util.List;

// Query testing utility
public class QueryTester {
    private SessionFactory sessionFactory;

    public QueryTester() {
        // Initialize the test-specific Hibernate configuration
        Configuration configuration = new Configuration();
        configuration.configure("test-hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public List<Object> executeQuery(String hqlQuery) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery(hqlQuery);
        List<Object> results = query.list();
        session.getTransaction().commit();
        return results;
    }
}

import org.junit.Test;
import static org.junit.Assert.*;

// Example test case
public class MyQueryTest {
    @Test
    public void testMyQuery() {
        QueryTester queryTester = new QueryTester();
        String hqlQuery = "FROM MyEntity WHERE name = 'John'";
        List<Object> results = queryTester.executeQuery(hqlQuery);
        // Assert the expected results
        assertNotNull(results); // Example assertion
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("MyQueryTest");
    }
}