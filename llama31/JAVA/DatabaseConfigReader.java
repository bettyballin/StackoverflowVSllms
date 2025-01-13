import java.lang.String;

public class DatabaseConfigReader {
    String dbUrl = System.getenv("DB_URL");
    String dbUsername = System.getenv("DB_USERNAME");
    String dbPassword = System.getenv("DB_PASSWORD");

    public static void main(String[] args) {
        DatabaseConfigReader reader = new DatabaseConfigReader();
        System.out.println("DB URL: " + reader.dbUrl);
        System.out.println("DB Username: " + reader.dbUsername);
        System.out.println("DB Password: " + reader.dbPassword);
    }
}