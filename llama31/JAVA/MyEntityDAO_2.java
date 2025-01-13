import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class MyEntityDAO_2_2 {
    public static void main(String[] args) {
        // Setup Hibernate
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Original code
        Query query = session.createQuery("FROM MyEntity WHERE name LIKE :searchTerm");
        query.setParameter("searchTerm", "%punkrock live%");
        List results = query.list();

        // Close Hibernate session
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}