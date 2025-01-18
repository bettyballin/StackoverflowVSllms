import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class None_26 {

    private Connection conn;
    private PreparedStatement cmdSelectData;
    private String SQL_SELECT_DATA = "SELECT * FROM your_table WHERE branch_id = ?";

    public void ExecuteSelect() {
        try {
            // Initialize your Connection
            conn = DriverManager.getConnection("your_connection_string");

            // Create and configure the command
            cmdSelectData = conn.prepareStatement(SQL_SELECT_DATA);

            // Execute multiple select statements with different parameters
            for (int branchId = 1; branchId <= 2; branchId++) {
                // Update the parameter value for each iteration
                cmdSelectData.setInt(1, branchId);

                // Fetch your data here
                // For example:
                // ResultSet rs = cmdSelectData.executeQuery();
                // while (rs.next()) {
                //     // process result
                // }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (cmdSelectData != null) cmdSelectData.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        None_26 obj = new None_26();
        obj.ExecuteSelect();
    }
}