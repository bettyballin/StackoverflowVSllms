import java.lang.String;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RunSqlScript {
    public static void main(String[] args) {
        String url = "jdbc:mysql:///x";
        String username = "x";
        String password = "x";
        String scriptPath = "/path/to/script.sql";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            File scriptFile = new File(scriptPath);
            Scanner scanner = new Scanner(scriptFile);

            while (scanner.hasNextLine()) {
                String query = scanner.nextLine();
                if (!query.trim().isEmpty()) {
                    stmt.execute(query);
                }
            }

            scanner.close();
        } catch (SQLException | FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}