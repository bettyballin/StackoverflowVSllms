import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Interceptor;

public class SessionFactoryBuilder {
    Configuration configuration = new Configuration();
    SessionFactory sessionFactory;

    {
        configuration.setInterceptor(new EscapeUnderscoreInterceptor());
        sessionFactory = configuration.buildSessionFactory();
    }

    public static void main(String[] args) {
    }
}

class EscapeUnderscoreInterceptor implements Interceptor {
    // Implement necessary methods here
    // For compilation purposes, methods can be left empty
}