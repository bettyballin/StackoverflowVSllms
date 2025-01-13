import java.util.List;

import javax.persistence.Query;
import javax.persistence.Session;
import javax.persistence.SessionFactory;

public class ADataAccessor {
    private SessionFactory sessionFactory;

    public ADataAccessor(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<A> getResults() {
        Session session = sessionFactory.getCurrentSession();
        Query<A> query = session.createQuery("FROM A", A.class);
        List<A> results = query.getResultList();
        return results;
    }

    public static void main(String[] args) {
        // To make this code executable, you need to create an instance of SessionFactory
        // and pass it to ADataAccessor. You also need to define the class A.
        // Here's an example:

        // Create a SessionFactory
        SessionFactory sessionFactory = createSessionFactory();

        // Create an instance of ADataAccessor
        ADataAccessor accessor = new ADataAccessor(sessionFactory);

        // Call the getResults method
        List<A> results = accessor.getResults();

        // Process the results
        for (A result : results) {
            System.out.println(result);
        }
    }

    // Helper method to create a SessionFactory
    private static SessionFactory createSessionFactory() {
        // This is a placeholder for creating a SessionFactory.
        // You need to implement this method based on your actual database configuration.
        return null;
    }
}

// Define the class A
class A {
    // Add fields and methods as needed
}