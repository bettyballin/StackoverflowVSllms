import java.lang.String;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ResultSetViewer {
    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new ResultSetViewer().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ResultSetViewer() throws SQLException, ClassNotFoundException {
        frame = new JFrame("ResultSet Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a connection to the database
        String url = "jdbc:mysql://localhost:3306/yourDatabase";
        String user = "username";
        String password = "password";
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM yourTable")) {

            // Create a table model to hold the data
            DefaultTableModel model = new DefaultTableModel();

            // Add column names to the model
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            // Add rows to the model
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

            // Create a table with the model
            JTable table = new JTable(model);

            // Scroll pane to hold the table
            table.setFillsViewportHeight(true);
            JScrollPane scrollPane = new JScrollPane(table);

            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        }

        frame.pack();
    }

    public void setVisible(boolean visible) {
        this.frame.setVisible(visible);
    }
}