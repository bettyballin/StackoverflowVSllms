import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.TableColumnModel;
import javax.swing.JTable;

public class TableHeaderMouseListener {
    private JTable table;
    private TableColumnModel columnModel;

    public TableHeaderMouseListener(JTable table) {
        this.table = table;
        this.columnModel = table.getColumnModel();
        table.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = table.columnAtPoint(e.getPoint());
                if (column != -1) {
                    // Update the sorted column and ascending flag
                    columnModel.setSortedColumn(column);
                    columnModel.setAscending(!columnModel.isAscending());
                    // Update your SQL query to sort by the new column
                    // ...
                }
            }
        });
    }

    public static void main(String[] args) {
        // Create a new JTable
        JTable table = new JTable();
        // Create a new TableHeaderMouseListener
        TableHeaderMouseListener listener = new TableHeaderMouseListener(table);
    }
}