import java.lang.String;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utils {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Object getObjectById(Class<?> objClass, Long id) {
        try (Session session = sessionFactory.openSession()) { // Use try-with-resources for automatic closure
            return session.get(objClass, id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve object", e);
        }
    }

    // other static methods

    public static void main(String[] args) {
    }
}