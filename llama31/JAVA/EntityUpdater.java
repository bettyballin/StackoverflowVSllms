import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EntityUpdater {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Long id = 1L; // replace with your entity ID
        MyEntity newEntity = session.load(MyEntity.class, id);
        newEntity.setProperty("new value");

        session.refresh(newEntity); // Refresh the entity from the database
        MyEntity oldEntity = session.load(MyEntity.class, id);

        // Evaluate differences between newEntity and oldEntity

        session.update(newEntity);
        session.getTransaction().commit();
        session.close();
    }
}