import java.lang.String;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericDAO<T> {

    private Class<T> clazz;

    public GenericDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    protected Session getCurrentSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public T findById(Long id) {
        // No transaction needed for read operation
        Session session = getCurrentSession();
        return session.get(clazz, id);
    }

    public List<T> findAll() {
        // No transaction needed for read operation
        String query = "FROM " + clazz.getName();
        return getCurrentSession().createQuery(query, clazz).list();
    }

    public void createObject(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    public void deleteObject(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    public T updateObject(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            T updatedEntity = session.merge(entity);
            transaction.commit();
            return updatedEntity;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
    }
}