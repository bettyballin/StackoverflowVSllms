import java.lang.String;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MyApplication_2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            // Sample data
            String[] columnNames = {"Column1", "Column2"};
            Object[][] data = {
                    {"Row1-Cell1", "Row1-Cell2"},
                    {"Row2-Cell1", "Row2-Cell2"},
                    // Add more rows as needed...
            };

            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            JTable table = new JTable(model);

            frame.add(new JScrollPane(table));
            frame.setVisible(true);
        });
    }
}