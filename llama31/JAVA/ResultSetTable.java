import javax.swing.*;
import java.sql.*;

public class ResultSetTable {
    public static void main(String[] args) throws SQLException {
        // Create a connection and a query
        Connection conn = DriverManager.getConnection("your_database_url", "username", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");

        // Create a JTable and a DefaultTableModel
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();

        // Get the column names from the ResultSet
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            model.addColumn(metaData.getColumnName(i));
        }

        // Add the data to the model
        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = rs.getObject(i);
            }
            model.addRow(row);
        }

        // Set the model to the table and display it
        table.setModel(model);
        JFrame frame = new JFrame("ResultSet Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);

        // Close the connection
        rs.close();
        stmt.close();
        conn.close();
    }
}