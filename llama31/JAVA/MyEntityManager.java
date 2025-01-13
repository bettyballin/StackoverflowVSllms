import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.query.Query;

public class MyEntityManager {

    public static void main(String[] args) {
        // Create a session factory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // Create a stateless session
        StatelessSession session = sessionFactory.openStatelessSession();

        // Perform a query
        Query<MyEntity> query = session.createQuery("FROM MyEntity", MyEntity.class);
        List<MyEntity> results = query.getResultList();

        // Close the stateless session
        session.close();

        // Close the session factory
        sessionFactory.close();
    }
}