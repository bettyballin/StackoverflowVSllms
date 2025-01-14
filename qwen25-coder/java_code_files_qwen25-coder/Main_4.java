import org.apache.commons.lang3.StringEscapeUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import javax.servlet.http.HttpServletRequest;

public class Main {
    public static void main(String[] args) {
        // Assuming 'conn' is your active database connection
        Connection conn = null; // Initialize your database connection here
        HttpServletRequest request = null; // Initialize your request object here

        try {
            String sender = request.getParameter("sender");
            String text = request.getParameter("text");

            // Escape HTML
            sender = StringEscapeUtils.escapeHtml4(sender);
            text = StringEscapeUtils.escapeHtml4(text);

            PreparedStatement pStmt = conn.prepareStatement(
                "INSERT INTO test (ID, sender, message) VALUES (?, ?, ?)"
            );
            pStmt.setNull(1, Types.INTEGER); // Setting ID to null if auto-incremented
            pStmt.setString(2, sender);
            pStmt.setString(3, text);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}