import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil_1 {
    private static final String URL = "jdbc:mysql://localhost:3306/yourdatabase";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

	public static void main(String[] args) {
	}
}