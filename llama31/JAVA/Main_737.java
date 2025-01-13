import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.intercept.SchemaInterceptor;

public class Main_737 {
    public static void main(String[] args) {
        // assuming you have a method getSession() that returns a Hibernate Session
        Session session = getSession();
        SchemaInterceptor interceptor = new SchemaInterceptor();
        interceptor.setSchemaName("my_schema");
        session.setInterceptor(interceptor);
        // execute your query
        session.createQuery("FROM YourEntity").list(); // replace YourEntity with your actual entity class
    }

    // assuming you have a method getSession() that returns a Hibernate Session
    private static Session getSession() {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // assuming you have a hibernate.cfg.xml file
        SessionFactory sf = cfg.buildSessionFactory();
        return sf.openSession(); // changed from getCurrentSession() to openSession()
    }
}