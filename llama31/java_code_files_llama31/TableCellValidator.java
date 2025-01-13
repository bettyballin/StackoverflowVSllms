/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellEditor;

public class TableCellValidator {
    private int row = 0;
    private int column = 0;
    private JTable table = new JTable(10, 10);
    private TableCellEditor editor = new DefaultCellEditor(new JTextField()){

        @Override
        public Object getCellEditorValue() {
            String string = (String)super.getCellEditorValue();
            if (!TableCellValidator.this.isValid(string)) {
                JOptionPane.showMessageDialog(null, "Invalid input", "Error", 0);
            }
            return string;
        }
    };

    private boolean isValid(String string) {
        return string != null && !string.isEmpty();
    }

    public TableCellValidator() {
        this.table.getColumnModel().getColumn(this.column).setCellEditor(this.editor);
        JFrame jFrame = new JFrame("Table Cell Validator");
        jFrame.setDefaultCloseOperation(3);
        jFrame.add((Component)new JScrollPane(this.table), "Center");
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] stringArray) {
        SwingUtilities.invokeLater(TableCellValidator::new);
    }
}
