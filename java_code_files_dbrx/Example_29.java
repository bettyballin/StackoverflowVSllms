import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.AfterClass;

public class Example_29 {
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void setUp() throws Exception {
        Configuration configuration = new Configuration();
        configuration.setProperty("javax.persistence.jdbc.driver", "org.h2.Driver");
        configuration.setProperty("javax.persistence.jdbc.url", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        // add entities here and configure the database schema...

        sessionFactory = configuration.buildSessionFactory();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        if (sessionFactory != null) {
            try {
                sessionFactory.getCurrentSession().close(); // or flush/clear
            } catch (HibernateException ignored) {}
            sessionFactory.close();
        }
    }

    public static void main(String[] args) {
        // Your application logic here
    }
}