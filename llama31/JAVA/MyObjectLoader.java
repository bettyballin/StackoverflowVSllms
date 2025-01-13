import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

public class MyObjectLoader {
    public static void main(String[] args) {
        // Assuming MyObject is correctly defined elsewhere in your codebase
        // For demonstration purposes, let's assume MyObject's ID type is Long
        Long myObjectId = 1L; // Example ID

        // Set up Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // Assuming you have a hibernate.cfg.xml
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        // Load MyObject
        MyObject myObject = (MyObject) session.get(MyObject.class, myObjectId);
        // Hibernate.initialize(myObject); // This is generally not necessary if you're using FetchType.EAGER
        
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}