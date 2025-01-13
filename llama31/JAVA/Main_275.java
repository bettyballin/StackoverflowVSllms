import org.apache.commons.lang3.StringEscapeUtils;
import java.sql.*;

public class Main_275 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Assuming you have a Connection object named conn
        Connection conn = DriverManager.getConnection("your_database_url", "your_username", "your_password");

        String sender = StringEscapeUtils.escapeHtml4("some_sender"); // Replaced request.getParameter
        String text = StringEscapeUtils.escapeHtml4("some_text"); // Replaced request.getParameter

        PreparedStatement pStmt = conn.prepareStatement("INSERT INTO test VALUES (NULL, ?, ?)");
        pStmt.setString(1, sender);
        pStmt.setString(2, text);
        pStmt.executeUpdate();

        conn.close();
    }
}