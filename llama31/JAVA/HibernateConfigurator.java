import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfigurator {
    Properties properties = new Properties();
    {
        properties.put("hibernate.query.start_offset_zero", "true");

        SessionFactory sessionFactory = new Configuration()
            .addProperties(properties)
            .buildSessionFactory();
    }

    public static void main(String[] args) {
    }
}