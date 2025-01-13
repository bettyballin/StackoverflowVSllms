import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class UserDAO_5_5 {
    private SessionFactory sessionFactory;

    public UserDAO_5() {
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public List<User> getUsersByUsername(String username) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM User WHERE username = :username");
        query.setParameter("username", username);
        List<User> results = query.list();
        session.close();
        return results;
    }

    public static void main(String[] args) {
        UserDAO_5 dao = new UserDAO_5();
        List<User> users = dao.getUsersByUsername("exampleUsername");
        // Process the users list
    }
}