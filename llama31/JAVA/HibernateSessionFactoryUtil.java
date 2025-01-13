import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateSessionFactoryUtil {
    // Create a Hibernate session factory
    private static SessionFactory sf = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    public static void main(String[] args) {
        // Use Hibernate to perform DB operations
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<MyEntity> entities = session.createQuery("FROM MyEntity", MyEntity.class).list();
        // ...
        tx.commit();
        session.close();
    }
}