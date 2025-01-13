import net.sf.jdbcspy.JdbcSpy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class Main_287 {
    public static void main(String[] args) throws Exception {
        // Create a JdbcSpy instance
        JdbcSpy spy = new JdbcSpy();

        // Set up your JDBC connection
        Connection conn = DriverManager.getConnection("jdbc:spy:mysql://localhost:3306/mydb", "username", "password");

        // Use the connection as usual
        Statement stmt = conn.createStatement();
        stmt.execute("SELECT * FROM mytable");

        // Get the logged statements
        List<String> statements = spy.getLoggedStatements();

        // Print the logged statements
        for (String statement : statements) {
            System.out.println(statement);
        }
    }
}