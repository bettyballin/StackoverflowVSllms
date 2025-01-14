import java.lang.String;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MergedCellsTable {
    public static void main(String[] args) {
        DefaultTableModel model = new DefaultTableModel(
            new Object[][]{
                {"Row 1", "Cell 2", "Cell 3"},
                {"Multi-row\nspan", "Cell 5", "Cell 6"},
                {"", "Cell 8", "Cell 9"}
            },
            new String[]{"Column 1", "Column 2", "Column 3"}
        );

        JTable table = new JTable(model);
        CellSpan cellSpan = new CellSpan(table);

        // Spanning cells
        cellSpan.setRowSpan(0, 0, 2); // Cell at (0,0) spans 2 rows

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column
            ) {
                Component c = super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column
                );
                if (cellSpan.isToSpan(row, column)) setVisible(false);
                else {
                    setVisible(true);
                    cellSpan.setRowHeight(c, row);
                }
                return this;
            }
        });

        JFrame frame = new JFrame();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class CellSpan {
    JTable table;

    CellSpan(JTable table) {
        this.table = table;
    }

    public void setRowHeight(Component c, int row) {
        int currentHeight = (int) c.getPreferredSize().getHeight();
        if (currentHeight > table.getRowHeight(row)) {
            table.setRowHeight(row, currentHeight);
        }
    }

    public void setColumnWidth(JTable table, Component c, int column) {
        table.getColumnModel().getColumn(column).setWidth(c.getPreferredSize().width);
        table.getColumnModel().getColumn(column).setMaxWidth(c.getPreferredSize().width);
        table.getColumnModel().getColumn(column).setMinWidth(c.getPreferredSize().width);
        table.getColumnModel().getColumn(column).setPreferredWidth(c.getPreferredSize().width);
    }

    public void setRowSpan(int row, int column, int span) {
        ((DefaultTableModel) table.getModel()).setValueAt(new CellSpanRow(row, column, span), row, column);
    }

    public boolean isToSpan(int row, int column) {
        return getStartCellSpan(row, column) != null;
    }

    public CellSpanRow getStartCellSpan(int row, int column) {
        for (int c = 0; c < table.getColumnCount(); c++) {
            for (int r = 0; r < table.getRowCount(); r++) {
                Object value = table.getValueAt(r, c);
                if (!(value instanceof CellSpanRow)) continue;
                CellSpanRow cellSpanRow = ((CellSpanRow) value);
                boolean cond1 = row >= r && row < cellSpanRow.row + cellSpanRow.span;
                boolean cond2 = column == c || (column > c && !isToSpan(r, column - 1));
                if (cond1 && cond2) {
                    return !cellSpanRow.isLast(column) ? cellSpanRow : null;
                }
            }
        }
        return null;
    }

    private static class CellSpanRow {
        int row;
        int column;
        int span;

        public CellSpanRow(int row, int column, int span) {
            this.row = row;
            this.column = column;
            this.span = span;
        }

        boolean isLast(int col) {
            return column + span - 1 == col;
        }
    }
}