import java.lang.String;
import java.sql.*;

public class SecureQueryExecutor {
    public static void main(String[] args) {
        try {
            String query = "SELECT * FROM table_name WHERE id = ?"; // ? is a placeholder for input data

            Connection connection = null; // Assume this is initialized elsewhere
            int id = 0; // Sample ID

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, id); // Binding the input value to the first '?'
            ResultSet result = preparedStmt.executeQuery();

            // Process the result as needed
            // while (result.next()) {
            //     // Access result data
            // }
            result.close();
            preparedStmt.close();
            // connection.close(); // Uncomment if the connection is not managed elsewhere

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}