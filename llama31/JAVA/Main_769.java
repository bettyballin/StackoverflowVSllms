import java.util.Arrays;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Assume a many-to-many relationship between User and Role
class User {
    private java.util.List<Role> roles;
    
    public void setRoles(java.util.List<Role> roles) {
        this.roles = roles;
    }
    
    public java.util.List<Role> getRoles() {
        return roles;
    }
}

class Role {
    private String name;

    public Role(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

// Added HibernateUtil class
class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
                sessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }
}

public class Main_769 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = new User();
        user.setRoles(Arrays.asList(new Role("Admin"), new Role("User")));

        // With SaveOrUpdate()
        // session.saveOrUpdate(user); // throws exception because Role objects are transient

        // With Merge()
        session.merge(user); // saves User and recursively saves Role objects

        session.getTransaction().commit();
        session.close();
    }
}