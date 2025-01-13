import java.util.List;
import java.util.ArrayList;

// Assuming you are using Hibernate for session and criteria
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criteria;

public class DataCombiner {
    public static void main(String[] args) {
        // Initialize the session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
        // Get a session
        Session session = sessionFactory.openSession();
        
        // Your original code
        Criteria criteria1 = session.createCriteria(Table1.class);
        Criteria criteria2 = session.createCriteria(Table2.class);

        List results1 = criteria1.list();
        List results2 = criteria2.list();

        List combinedResults = new ArrayList<>();
        combinedResults.addAll(results1);
        combinedResults.addAll(results2);
        
        // Close the session
        session.close();
        
        // Close the session factory
        sessionFactory.close();
    }
}