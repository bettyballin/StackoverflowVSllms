import java.lang.String;

public class DatabaseConnector_7_7 {
    String dbUrl = System.getenv("DB_URL");
    String dbUsername = System.getenv("DB_USERNAME");
    String dbPassword = System.getenv("DB_PASSWORD");

    // Use these values to establish a database connection
    public static void main(String[] args) {
        DatabaseConnector_7 connector = new DatabaseConnector_7();
        System.out.println("Database URL: " + connector.dbUrl);
        System.out.println("Database Username: " + connector.dbUsername);
        System.out.println("Database Password: " + connector.dbPassword);
    }
}