import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class YourClassName {

    private Session session;

    public List<Course> findAll() {
        List<Course> lst = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from Course");
            lst = q.list();

            // Fetch and initialize the related collections that you need to use here
            for (Course c : lst) {
                Hibernate.initialize(c.getRelatedCollection());  // replaced <relatedCollection> with a method
            }
            tx.commit();
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
        return lst;
    }
}

class Course {
    // Assuming there is a related collection
    private List<?> relatedCollection;

    public List<?> getRelatedCollection() {
        return relatedCollection;
    }

    // Other fields and methods
}