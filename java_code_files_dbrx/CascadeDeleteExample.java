import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class CascadeDeleteExample {
    public static void main(String[] args) {
        String cascadeDelete = "DELETE FROM parent_table WHERE id = ?;"
                + " DELETE FROM child_table WHERE parent_id = ?";
        Connection connection = null; // Assume connection is established

        try (PreparedStatement stmt = connection.prepareStatement(cascadeDelete)) {
            // set parameters values
            /* 
               ...
            */
            int[] result = stmt.executeBatch();
            System.out.println("Total rows affected: " + Arrays.stream(result).sum());
        } catch(SQLException ex) {
            /* 
               ... // handle exception
            */
        }
    }
}