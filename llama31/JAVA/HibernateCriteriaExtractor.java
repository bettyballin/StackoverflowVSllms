import org.hibernate.Criteria;
import org.hibernate.CriteriaImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCriteriaExtractor {
    public static void main(String[] args) {
        // Create a Hibernate session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
        // Create a Hibernate session
        Session session = sessionFactory.openSession();
        
        // Create criteria for the Operator class
        Criteria criteria = session.createCriteria(Operator.class);
        
        // ... build up the criteria ...
        
        // Cast the criteria to CriteriaImpl and get the SQL
        CriteriaImpl criteriaImpl = (CriteriaImpl) criteria;
        String sql = criteriaImpl.toString(); // Note: getSql() is not a method of CriteriaImpl

        // Print the SQL
        System.out.println(sql);

        // Close the session and session factory
        session.close();
        sessionFactory.close();
    }
}