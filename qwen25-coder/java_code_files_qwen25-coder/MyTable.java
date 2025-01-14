import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;

public class MyTable extends JFrame {
    private JTable table;
    private ResultSetTableModel model;
    private String currentSortColumn = "default_column"; // Default sort column name
    private boolean isAscending = true; // Track sort order

    public MyTable() throws Exception {
        model = new ResultSetTableModel();  // Assume this class extends AbstractTableModel
        table = new JTable(model);

        TableRowSorter<ResultSetTableModel> sorter = new TableRowSorter<>(model);
        sorter.setSortable(0, false);  // Example: Disable sorting on the first column if necessary

        table.setRowSorter(sorter);

        table.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = table.columnAtPoint(e.getPoint());
                if (col >= 0) {
                    String columnName = model.getColumnName(col);
                    if (columnName.equals(currentSortColumn)) {
                        isAscending = !isAscending; // Toggle sort order
                    } else {
                        currentSortColumn = columnName;
                        isAscending = true; // Default to ascending when sorting by a new column
                    }
                    updateSortIcon(sorter, col);
                    refreshTableData();  // Update SQL query and refresh table data
                }
            }
        });

        add(new JScrollPane(table));
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void updateSortIcon(RowSorter<?> sorter, int col) {
        SortOrder order = isAscending ? SortOrder.ASCENDING : SortOrder.DESCENDING;
        sorter.setSortKeys(Collections.singletonList(new RowSorter.SortKey(col, order)));
    }

    private void refreshTableData() {
        // Update your SQL query here using currentSortColumn and isAscending
        // After updating the query, refill the model data based on new ResultSet
        try {
            model.refreshData(currentSortColumn, isAscending);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            try {
                MyTable frame = new MyTable();
                frame.setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}

// Assume this class extends AbstractTableModel
class ResultSetTableModel extends AbstractTableModel {
    private String[] columnNames = { "Column1", "Column2", "Column3" }; // Example column names
    private Object[][] data = {
        { "Data1", "Data2", "Data3" },
        { "Data4", "Data5", "Data6" },
        { "Data7", "Data8", "Data9" }
    };

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public void refreshData(String sortColumn, boolean isAscending) {
        // Implement database query to refresh data based on sortColumn and isAscending
        // For now, just print out what would happen
        System.out.println("Refreshing data sorted by " + sortColumn + " in "
                + (isAscending ? "ascending" : "descending") + " order.");
        // In a real implementation, you'd fetch new data and fire table data changed events.
    }
}