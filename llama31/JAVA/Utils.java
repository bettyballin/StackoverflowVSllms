import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utils {
    public static synchronized Object getObjectById (Class objclass, Long id) {
         // call hibernate class
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Object obj = session.load(objclass, id);
        session.close();
        sessionFactory.close();
        return obj;
    }

    // other static methods

	public static void main(String[] args) {
	}
}