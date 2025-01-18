import java.lang.String;
public class EnvironmentDatabaseCredentials {
    String dbUsername = System.getenv("DB_USERNAME");
    String dbPassword = System.getenv("DB_PASSWORD");
    public static void main(String[] args) {
    }
}