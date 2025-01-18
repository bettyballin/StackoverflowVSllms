import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlBatchDeleter {
    public static void main(String[] args) {
        StringBuilder sql = new StringBuilder("DELETE FROM MyTable WHERE myPrimaryKey IN (");
        long[] keysToDelete = { 0, 1, 2, 3 };
        for(int i = 0; i < keysToDelete.length; i++){
            if(i > 0) sql.append(", "); // to separate the placeholders for each ID in the set
            sql.append("?");
        }
        sql.append(')'); // closing the bracket of 'IN' clause.

        try (Connection conn = DriverManager.getConnection("your-database-url");
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            for(int i = 0; i < keysToDelete.length; i++){   // set parameter value for each placeholder in sql query string.
                pstmt.setLong(i + 1, keysToDelete[i]);  // Note: index starts at 1
            }
            int countDeleted = pstmt.executeUpdate(); // executes the SQL DELETE command with given parameters and deletes those rows from table
        } catch (SQLException ex) {
            // error handling here for any exception
            ex.printStackTrace();
        }
    }
}