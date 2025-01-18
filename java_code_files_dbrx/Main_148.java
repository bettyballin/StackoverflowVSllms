import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class Main {

    public static void main(String[] args) {
        DefaultTableModel tableModel = new DefaultTableModel();

        // Add some data to the table model to enable updates
        tableModel.addColumn("Column1");
        tableModel.addRow(new Object[]{"Value1"});

        tableModel.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE){
                    // Fetch the previous version from your row data structure here, possibly using a Map or similar.
                    System.out.println("Table updated at row " + e.getFirstRow() + ", column " + e.getColumn());
                }
            }
        });

        // Simulate an update to trigger the listener
        tableModel.setValueAt("UpdatedValue1", 0, 0);
    }
}