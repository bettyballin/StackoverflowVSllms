import java.lang.String;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class DatabaseTableExample {
    public static void main(String[] args) {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("url", "username", "password");
        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            return;
        }

        // Create a TableModel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("City");
        model.addColumn("Date");

        // Retrieve data from database and add to TableModel
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDate(4)});
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving data from database");
        }

        // Create a JTable and set the TableModel
        JTable table = new JTable(model);

        // Add the JTable to a JScrollPane and add it to your GUI
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
    }
}