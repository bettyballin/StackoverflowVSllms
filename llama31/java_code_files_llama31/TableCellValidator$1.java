/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class TableCellValidator.1
extends DefaultCellEditor {
    TableCellValidator.1(JTextField jTextField) {
        super(jTextField);
    }

    @Override
    public Object getCellEditorValue() {
        String string = (String)super.getCellEditorValue();
        if (!TableCellValidator.this.isValid(string)) {
            JOptionPane.showMessageDialog(null, "Invalid input", "Error", 0);
        }
        return string;
    }
}
