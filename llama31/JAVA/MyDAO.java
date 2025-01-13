import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class MyDAO {
    private SessionFactory sessionFactory;

    public MyDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<MyEntity> findAll() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Query<MyEntity> query = session.createQuery("from MyEntity", MyEntity.class);
            List<MyEntity> entities = query.getResultList();
            session.getTransaction().commit();
            return entities;
        }
    }

    public static void main(String[] args) {
    }
}