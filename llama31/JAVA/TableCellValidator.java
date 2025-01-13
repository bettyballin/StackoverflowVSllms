import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class TableCellValidator {
    // Row and column for the cell to be validated
    private int row = 0;
    private int column = 0;
    
    // Create a table for the data
    private JTable table = new JTable(10, 10); // Example table size
    
    // Create a TableCellEditor to validate input
    private TableCellEditor editor = new DefaultCellEditor(new JTextField()) {
        @Override
        public Object getCellEditorValue() {
            String text = (String) super.getCellEditorValue();
            if (!isValid(text)) {
                // Example: Show an error message
                JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return text;
        }
    };

    // Simple validation method
    private boolean isValid(String text) {
        // Example validation: check if the string is not empty
        return text != null && !text.isEmpty();
    }

    public TableCellValidator() {
        // Set the editor for the table
        table.getColumnModel().getColumn(column).setCellEditor(editor);
        
        // Show the table in a JFrame
        JFrame frame = new JFrame("Table Cell Validator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TableCellValidator::new);
    }
}