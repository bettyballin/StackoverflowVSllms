import java.util.Collection;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.criterion.DetachedCriteria;

public class ObjectRetriever {
    private SessionFactory sessionFactory;

    public Collection retrieveObjects() {
        StatelessSession session = sessionFactory.openStatelessSession();
        DetachedCriteria criteria = DetachedCriteria.forClass(Object.class);
        Collection result = session.createCriteria(criteria).list();
        session.close();
        return result;
    }

    public static void main(String[] args) {
        // You need to create an instance of ObjectRetriever and call retrieveObjects()
        // You also need to initialize the sessionFactory variable
    }
}