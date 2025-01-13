import java.lang.String;
import javax.swing.*;
import javax.swing.table.*;

public class CustomTableColumnModel extends DefaultTableColumnModel {

    private int sortedColumn = -1;
    private boolean ascending = true;

    public CustomTableColumnModel() {
        super();
    }

    @Override
    public void addColumnModelListener(TableColumnModelListener l) {
        super.addColumnModelListener(l);
    }

    public void setSortedColumn(int column) {
        this.sortedColumn = column;
        fireColumnMarginChanged();
    }

    public int getSortedColumn() {
        return sortedColumn;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
        fireColumnMarginChanged();
    }

    public boolean isAscending() {
        return ascending;
    }

    @Override
    protected TableColumn createColumn(int index) {
        TableColumn column = super.createColumn(index);
        column.setHeaderRenderer(new SortableHeaderRenderer());
        return column;
    }

    private class SortableHeaderRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == sortedColumn) {
                label.setIcon(ascending ? new ImageIcon("up_arrow.png") : new ImageIcon("down_arrow.png"));
            } else {
                label.setIcon(null);
            }
            return label;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom Table Column Model");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable table = new JTable(5, 5);
        table.setColumnModel(new CustomTableColumnModel());

        frame.getContentPane().add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
    }
}