import java.sql.*;
import javax.swing.JComboBox;

public class Main_438 {
    // Assuming you have a Connection object 'conn' and a JComboBox 'yearComboBox'
    public static void fillYearComboBox(Connection conn, JComboBox yearComboBox) {
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT DISTINCT YEAR(date_field) AS year FROM your_table")) {
            while (rs.next()) {
                yearComboBox.addItem(rs.getInt("year"));
            }
        } catch (SQLException e) {
            // Handle SQL exception
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create a new JComboBox
        JComboBox yearComboBox = new JComboBox();

        // Establish a connection to the database
        String dbUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";
        try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
            fillYearComboBox(conn, yearComboBox);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}