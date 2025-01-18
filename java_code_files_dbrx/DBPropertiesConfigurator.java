import java.util.Properties;

public class DBPropertiesConfigurator {
    static Properties properties = new Properties();

    static {
        properties.setProperty("hibernate.connection.url", "jdbc:sqlserver://localhost;databaseName=your_db");
    }

    public static void main(String[] args) {
    }
}