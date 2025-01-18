import java.util.Properties;

public class DatabaseConfiguration {
    String url = "jdbc:oracle:thin:@localhost:1521:xe?oracle.jdbc.convertMetadataDefs=false";
    Properties properties = new Properties();

    {
        properties.setProperty("hibernate.connection.url", url);
    }

    public static void main(String[] args) {
    }
}