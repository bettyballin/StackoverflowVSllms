import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.internal.DataSourceConnectionProvider;
import javax.sql.DataSource;

public class HibernateUtil {
    DataSource dataSource;

    SessionFactory sessionFactory = new Configuration()
        .setConnectionProvider(
            // Pass in your DataSource instance here...
            new DataSourceConnectionProvider(dataSource)
        )
        .buildSessionFactory();

    public static void main(String[] args) {
    }
}