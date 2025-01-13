// Example using Hibernate with native Oracle query
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.util.List;

public class Main_265 {
    public static void main(String[] args) {
        // Assuming sessionFactory is already configured and initialized
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String nativeQuery = "SELECT * FROM my_table CONNECT BY LEVEL <= 5";
        Query query = session.createNativeQuery(nativeQuery);
        List results = query.getResultList();

        // You may want to print or process the results here
        System.out.println(results);
        session.getTransaction().commit();
        sessionFactory.close();
    }
}