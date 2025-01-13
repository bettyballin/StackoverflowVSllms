import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CRUDExample {
    public static void main(String[] args) {
        // Create a database connection
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return;
        }

        // Create a table model to map database fields to JTable columns
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Email");

        // Populate the table model with data from the database
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM mytable");
            while (rs.next()) {
                model.addRow(new Object[] { rs.getInt("id"), rs.getString("name"), rs.getString("email") });
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing connections: " + e.getMessage());
            }
        }

        // Create a JTable to display the data
        JTable table = new JTable(model);

        // Add CRUD buttons to the UI
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add a new row to the table model
                model.addRow(new Object[] { 0, "", "" });
            }
        });

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Update the selected row in the table model
                int row = table.getSelectedRow();
                if (row >= 0) {
                    model.setValueAt(table.getValueAt(row, 0), row, 0);
                    model.setValueAt(table.getValueAt(row, 1), row, 1);
                    model.setValueAt(table.getValueAt(row, 2), row, 2);
                }
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Delete the selected row from the table model
                int row = table.getSelectedRow();
                if (row >= 0) {
                    model.removeRow(row);
                }
            }
        });

        // Create a JFrame to display the UI
        JFrame frame = new JFrame("CRUD Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(table), "Center");
        frame.getContentPane().add(addButton, "North");
        frame.getContentPane().add(updateButton, "East");
        frame.getContentPane().add(deleteButton, "West");
        frame.pack();
        frame.setVisible(true);
    }
}