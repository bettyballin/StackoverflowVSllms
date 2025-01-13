import java.lang.String;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HierarchicalTable {
    public static void main(String[] args) {
        // Create the table model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("2008");
        model.addColumn("January");
        model.addColumn("February");

        // Add sub-columns
        model.addColumn("Week1");
        model.addColumn("Week2");
        model.addColumn("Week3");
        model.addColumn("Week1");
        model.addColumn("Week2");
        model.addColumn("Week3");

        // Add data
        model.addRow(new Object[]{"", "", "", 10, 20, 14, 12, 15, 3});

        // Create the table
        JTable table = new JTable(model);

        // Create a panel for the header
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());

        // Create a label for the top-level header
        JLabel topLevelHeader = new JLabel("2008");
        headerPanel.add(topLevelHeader, BorderLayout.NORTH);

        // Create a panel for the sub-headers
        JPanel subHeaderPanel = new JPanel();
        subHeaderPanel.setLayout(new GridLayout(1, 2));

        // Create labels for the sub-headers
        JLabel januaryLabel = new JLabel("January");
        JLabel februaryLabel = new JLabel("February");
        subHeaderPanel.add(januaryLabel);
        subHeaderPanel.add(februaryLabel);

        // Add the sub-headers to the header panel
        headerPanel.add(subHeaderPanel, BorderLayout.CENTER);

        // Create a scroll pane for the table
        JScrollPane tableScrollPane = new JScrollPane(table);

        // Add the header panel to the scroll pane
        tableScrollPane.setRowHeaderView(headerPanel);

        // Create a frame and add the scroll pane
        JFrame frame = new JFrame("Hierarchical Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(tableScrollPane);
        frame.pack();
        frame.setVisible(true);
    }
}