import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RunScriptUsingJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql:///x";
        String user = "x";
        String password = "x";
        String filePath = "/path/to/your/script.sql"; // Update this path

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty() && !line.startsWith("--") && !line.startsWith("/*") && !line.endsWith("*/")) {
                    sql.append(line);
                    // Check if this line completes the statement
                    if (line.endsWith(";")) {
                        stmt.execute(sql.toString());
                        sql.setLength(0); // Reset the string buffer for next statement
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}