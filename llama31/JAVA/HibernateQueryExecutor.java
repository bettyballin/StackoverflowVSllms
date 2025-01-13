import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateQueryExecutor {
    public static void main(String[] args) {
        // Create a Hibernate session factory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // Create a Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Create a native SQL query
        Query query = session.createNativeQuery("SELECT * FROM table1 UNION SELECT * FROM table2");

        // Execute the query and get the results
        List results = query.getResultList();

        // Print the results
        System.out.println(results);
    }
}