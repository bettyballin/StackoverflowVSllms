import java.lang.String;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JTableExample {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JTableExample().createUI());
    }

    private void createUI() {
        frame = new JFrame("JTable Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        model = new DefaultTableModel(new String[]{"Name", "Age", "City", "Date"}, 0);

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData();
            }
        });

        frame.getContentPane().add(refreshButton, "South");

        // Initial data load
        loadData();

        frame.setVisible(true);
    }

    private void loadData() {
        model.setRowCount(0); // Clear existing rows

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "username", "password");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name, age, city, date FROM your_table")) {

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String city = rs.getString("city");
                String date = rs.getString("date");

                model.addRow(new Object[]{name, age, city, date});
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
        }
    }
}