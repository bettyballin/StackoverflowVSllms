/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class TableModelChangeListener {
    public static void main(String[] stringArray) {
        final DefaultTableModel defaultTableModel = new DefaultTableModel();
        final JTable jTable = new JTable();
        defaultTableModel.addTableModelListener(new TableModelListener(){

            @Override
            public void tableChanged(TableModelEvent tableModelEvent) {
                jTable.setModel(defaultTableModel);
            }
        });
    }
}
