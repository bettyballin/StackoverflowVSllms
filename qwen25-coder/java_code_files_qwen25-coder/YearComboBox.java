import java.lang.String;
import java.lang.Integer;
import java.sql.*;
import javax.swing.*;

public class YearComboBox {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Year Combo Box Example");
        JComboBox<Integer> yearComboBox = new JComboBox<>();
        populateComboBoxWithYears(yearComboBox);
        
        frame.add(yearComboBox);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void populateComboBoxWithYears(JComboBox<Integer> comboBox) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT DISTINCT YEAR(your_date_column) AS year FROM your_table")) {

            while (rs.next()) {
                int year = rs.getInt("year");
                comboBox.addItem(year);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}