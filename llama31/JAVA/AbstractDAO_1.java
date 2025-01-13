import java.lang.String;

// Add necessary Hibernate imports
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

// Assuming HibernateUtil is a utility class to get Hibernate SessionFactory
import yourpackage.HibernateUtil;

// Assuming DataAccessLayerException is a custom exception class
import yourpackage.DataAccessLayerException;

public class AbstractDAO_1_1<T> {

    public AbstractDAO_1() {} // Constructor should have the same name as the class

    public void createObject(T object) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(object);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            throw new DataAccessLayerException(e);
        } finally {
            session.close();
        }
    }

    // Other methods...

    public static void main(String[] args) {
    }
}