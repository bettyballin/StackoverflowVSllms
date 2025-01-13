import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil_2_2 {
    private static final SessionFactory sessionFactory = createSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory createSessionFactory() {
        // create a Hibernate session factory using a configuration file or programmatically
        return new Configuration().configure().buildSessionFactory();
    }

    public static void main(String[] args) {
    }
}