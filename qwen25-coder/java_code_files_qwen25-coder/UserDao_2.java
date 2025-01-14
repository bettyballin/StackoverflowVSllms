import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Repository { }

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Autowired { }

class User {
    // User properties and methods
}

class Session {
    public void saveOrUpdate(User user) {
        // Implement saveOrUpdate functionality
    }

    public Object load(Class clazz, Object id) {
        // Implement load functionality
        return null;
    }
}

class SessionFactory {
    public Session getCurrentSession() {
        return new Session();
    }
}

@Repository
public class UserDao_2 {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveUser(User user) {
        getSession().saveOrUpdate(user);
    }

    public User lookupUser(String webUserId) {
        return (User) getSession().load(User.class, webUserId);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}