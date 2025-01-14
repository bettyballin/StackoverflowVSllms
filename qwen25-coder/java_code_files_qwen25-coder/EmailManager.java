import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Array;

public class EmailManager {
    private Connection connection = null;
    private PreparedStatement updateStmt = null;
    private PreparedStatement deleteStmt = null;
    private Form form;
    private User user;

    public EmailManager() {
        form = new Form();
        user = new User();
    }

    public void processEmails() {
        try {
            // Establish a connection (details of DriverManager.getConnection() are omitted for brevity)
            connection = DriverManager.getConnection("your_connection_string", "username", "password");
            connection.setAutoCommit(false);

            // Emails in form
            ArrayList<String> emailsInForm = form.getAllMails();

            // Insert or update emails using merge statement (if supported by your DB, otherwise use separate insert and update)
            String sqlMerge = "MERGE INTO EMAIL e USING (SELECT ? as email, ? as user_id FROM dual) src ON (e.email = src.email AND e.user_id = src.user_id) WHEN NOT MATCHED THEN INSERT (email, user_id) VALUES (src.email, src.user_id)";

            updateStmt = connection.prepareStatement(sqlMerge);
            for (String email : emailsInForm) {
                updateStmt.setString(1, email);
                updateStmt.setLong(2, user.getId());
                updateStmt.addBatch();
            }
            updateStmt.executeBatch();

            // Delete emails not in the form
            String sqlDelete = "DELETE FROM EMAIL WHERE user_id = ? AND email NOT IN (SELECT * FROM TABLE(CAST(? AS SYS.ODCIVARCHAR2LIST)))";

            deleteStmt = connection.prepareStatement(sqlDelete);
            deleteStmt.setLong(1, user.getId());
            deleteStmt.setArray(2, connection.createArrayOf("VARCHAR", emailsInForm.toArray()));
            deleteStmt.executeUpdate();

            // Commit transaction
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) try { connection.rollback(); } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (updateStmt != null) updateStmt.close();
                if (deleteStmt != null) deleteStmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        EmailManager manager = new EmailManager();
        manager.processEmails();
    }
}

class Form {
    public ArrayList<String> getAllMails() {
        // Dummy implementation
        return new ArrayList<String>();
    }
}

class User {
    public long getId() {
        // Dummy implementation
        return 1L;
    }
}