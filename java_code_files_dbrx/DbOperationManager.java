import java.lang.String;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DbOperationManager {

    SessionFactory sessionFactory;
    MyEntity object1 = new MyEntity();

    public DbOperationManager() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        session.saveOrUpdate(object1); // will insert as new row because no existing object in DB
        session.getTransaction().commit();
    }

    public static void main(String[] args) {
        new DbOperationManager();
    }

    public class MyEntity {
        // Define properties and methods as needed
    }
}