import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import javax.sql.DataSource;

public class Main_351 {
    public static void main(String[] args) {
        // Create a DataSource instance (replace with your actual DataSource implementation)
        DataSource dataSource = java.sql.DriverManager.getDataSource("jdbc:mysql://localhost:3306/mydb");

        Configuration cfg = new Configuration();
        cfg.setProperty("hibernate.connection.datasource", dataSource);
        cfg.configure();

        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        StandardServiceRegistry standardServiceRegistry = sb.applySettings(cfg.getProperties()).build();

        SessionFactory sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
    }
}