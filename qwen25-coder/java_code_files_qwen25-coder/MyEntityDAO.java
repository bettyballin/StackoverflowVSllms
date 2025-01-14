import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MyEntityDAO {

    // Method to find all entities
    public List<MyEntity> findAll(boolean initializeCollections) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            String hql = "FROM MyEntity";
            Query<MyEntity> query = session.createQuery(hql, MyEntity.class);
            List<MyEntity> entities = query.list();

            // If collections need to be initialized lazily
            if (initializeCollections) {
                for (MyEntity entity : entities) {
                    Hibernate.initialize(entity.getCollectionField());
                }
            }

            transaction.commit();
            return entities;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
    }
}

class MyEntity {
    public Object getCollectionField() {
        return null;
    }
}

class HibernateUtil {
    public static SessionFactory getSessionFactory() {
        return null;
    }
}