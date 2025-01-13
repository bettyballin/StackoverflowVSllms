import java.sql.*;

public class UpdateRow {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/yourDatabase";
        String username = "yourUsername";
        String password = "yourPassword";
        String tableName = "yourTableName";
        int rowId = 1; // Specify the row ID you want to update
        String columnName = "yourColumnName"; // Specify the column you want to update
        String newValue = "newValue"; // Specify the new value for the column

        try (Connection conn = DriverManager.getConnection(dbUrl, username, password);
             PreparedStatement pstmt = conn.prepareStatement("UPDATE " + tableName + " SET " + columnName + " = ? WHERE id = ?")) {

            pstmt.setString(1, newValue); // Set the new value
            pstmt.setInt(2, rowId); // Set the row ID

            pstmt.executeUpdate();
            System.out.println("Row updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating row: " + e.getMessage());
        }
    }
}