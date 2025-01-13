import java.util.List;

// Generic DAO interface
public interface GenericDAO<T> {
    T findById(Long id);
    List<T> findAll();
    void create(T entity);
    void update(T entity);
    void delete(T entity);
}

// Generic DAO implementation
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {
    private final Class<T> clazz;
    private final SessionFactory sessionFactory;

    public GenericDAOImpl(Class<T> clazz, SessionFactory sessionFactory) {
        this.clazz = clazz;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public T findById(Long id) {
        return sessionFactory.getCurrentSession().get(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM " + clazz.getName()).list();
    }

    @Override
    public void create(T entity) {
        sessionFactory.getCurrentSession().persist(entity);
    }

    @Override
    public void update(T entity) {
        sessionFactory.getCurrentSession().merge(entity);
    }

    @Override
    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}

// Concrete DAO implementation
public class UserDAO_3 extends GenericDAOImpl<User> {
    public UserDAO(SessionFactory sessionFactory) {
        super(User.class, sessionFactory);
    }

    public static void main(String[] args) {
    }
}

// User class (assuming it's a simple POJO)
class User {
    // User properties and getters/setters
}

// SessionFactory class (assuming it's a simple implementation)
class SessionFactory {
    public Session getCurrentSession() {
        // Return a Session object
        return new Session();
    }
}

// Session class (assuming it's a simple implementation)
class Session {
    public <T> T get(Class<T> clazz, Long id) {
        // Return an object of type T
        return null;
    }

    public <T> List<T> createQuery(String query) {
        // Return a List of objects of type T
        return null;
    }

    public void persist(Object entity) {
        // Persist the entity
    }

    public void merge(Object entity) {
        // Merge the entity
    }

    public void delete(Object entity) {
        // Delete the entity
    }
}