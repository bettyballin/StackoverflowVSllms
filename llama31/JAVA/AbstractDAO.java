import java.lang.String;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateUtil;

public class AbstractDAO<T> {

    public AbstractDAO() {}

    public void createObject(T object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(object);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw new DataAccessLayerException(e);
        } finally {
            session.close();
        }
    }

    // Other methods...

    public static void main(String[] args) {
    }
}

class DataAccessLayerException extends RuntimeException {
    public DataAccessLayerException(Throwable cause) {
        super(cause);
    }
}