import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.lang.String;

public class HibernateUtil_1_1 {
    private static final ThreadLocal<Session> session = new ThreadLocal<Session>();

    public static Session getSession() {
        Session s = session.get();
        if (s == null) {
            s = createSession();
            session.set(s);
        }
        return s;
    }

    private static Session createSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public static void closeSession() {
        Session s = session.get();
        if (s != null) {
            s.close();
            session.set(null);
        }
    }

    public static void main(String[] args) {
    }
}

class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        // Initialize the session factory
        sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}