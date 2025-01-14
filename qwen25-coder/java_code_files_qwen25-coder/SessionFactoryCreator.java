import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class SessionFactoryCreator {
    Configuration configuration = new Configuration();
    SessionFactory sessionFactory;

    {
        configuration.setInterceptor(new ContentInterceptor());
        sessionFactory = configuration.buildSessionFactory();
    }

    public static void main(String[] args) {
    }
}