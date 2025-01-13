import org.hibernate.cfg.Configuration;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.connection.DatasourceConnectionProviderImpl;
import javax.sql.DataSource;

public class Main_352 {
    public static void main(String[] args) {
        // Replace with your existing DataSource instance
        DataSource dataSource = null; 

        DatasourceConnectionProviderImpl connectionProvider = new DatasourceConnectionProviderImpl();
        connectionProvider.setDataSource(dataSource);

        Configuration cfg = new Configuration();
        cfg.setProperty("hibernate.connection.provider_class", connectionProvider.getClass().getName());
    }
}