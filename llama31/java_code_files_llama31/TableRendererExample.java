/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableRendererExample {
    public static void main(String[] stringArray) {
        TableRendererExample tableRendererExample = new TableRendererExample();
    }

    public TableRendererExample() {
        JTable jTable = new JTable();
        jTable.setModel(new DefaultTableModel(new Object[][]{{"Row 1, Col 1", "Row 1, Col 2"}, {"Row 2, Col 1", "Row 2, Col 2"}}, new String[]{"Column 1", "Column 2"}));
        jTable.getColumnModel().getColumn(1).setCellRenderer(new MergedCellRenderer());
    }
}
