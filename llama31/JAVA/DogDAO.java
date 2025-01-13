import org.hibernate.Session;
import org.hibernate.query.Query;

public class DogDAO {
    Session session; // You need to initialize this session

    public DogDAO(Session session) {
        this.session = session;
    }

    public void someMethod() {
        Query query = session.createSQLQuery("SELECT rownum, d.* FROM (SELECT * FROM Dog WHERE ...) d");
    }

    public static void main(String[] args) {
        // You need to create a session and then create an instance of DogDAO
        // Session session = HibernateUtil.getSessionFactory().openSession();
        // DogDAO dogDAO = new DogDAO(session);
        // dogDAO.someMethod();
    }
}