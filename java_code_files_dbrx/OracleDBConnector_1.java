import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class OracleDBConnector_1 {
    String url = "jdbc:oracle:thin:@localhost:1521:mydb"; // Replace these values with the appropriate ones for your Oracle database.
    Connection conn;
    String jdbcUserName = "jdbcUserName"; // Define this variable
    String jdbcPassword = "jdbcPassword"; // Define this variable
    String query = "SELECT * FROM OtherUsersSchema.OtherTable";
    Statement stmt;
    ResultSet result;

    {
        try {
            conn = DriverManager.getConnection(url, jdbcUserName, jdbcPassword);
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}