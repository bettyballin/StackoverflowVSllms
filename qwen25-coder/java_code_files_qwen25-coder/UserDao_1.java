import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {
    private static final UserDao INSTANCE = new UserDao();
    private SessionFactory sessionFactory;

    // Private constructor to prevent instantiation
    private UserDao() {
        // Initialize the session factory or other resources here
        this.sessionFactory = HibernateUtil.getSessionFactory(); // Hypothetical utility for obtaining SessionFactory
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }

    // DAO methods
    public void saveUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) transaction.rollback();
            throw e; // or handle appropriately
        } finally {
            session.close();
        }
    }

    // Other CRUD methods...

    public static void main(String[] args) {
    }
}