import java.lang.String;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MergedCellRenderer implements TableCellRenderer {
    private JTextArea textArea;

    public MergedCellRenderer() {
        textArea = new JTextArea();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        textArea.setText(value.toString());
        if (column == 1 && row == 1) { // merge cell at row 1, column 1
            textArea.setRows(2); // set the row span
        } else {
            textArea.setRows(1);
        }
        return textArea;
    }

	public static void main(String[] args) {
	}
}