import javax.swing.*;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.*;
import java.awt.*;
import java.util.Vector;
import javax.swing.border.*;

public class HierarchicalTableExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hierarchical Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sample data
        String[][] data = {
            {"10", "20", "14", "12", "15", "3"}
        };

        // Column headers setup
        String[] columnNames = {"Week1", "Week2", "Week3", "Week1", "Week2", "Week3"};
        Class[] columnTypes = {String.class, String.class, String.class, String.class, String.class, String.class};

        // Create a custom table model
        AbstractTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        };

        JTable table = new JTable(tableModel);
        GroupableTableHeader header = new GroupableTableHeader(table.getColumnModel());
        table.setTableHeader(header);

        // Create groups
        ColumnGroup g_2008 = new ColumnGroup("2008");
        ColumnGroup g_January = new ColumnGroup("January");
        ColumnGroup g_February = new ColumnGroup("February");

        header.addGroup(g_2008);
        g_2008.add(g_January);
        g_2008.add(g_February);

        for (int i = 0; i < 3; i++) {
            g_January.add(table.getColumnModel().getColumn(i));
        }
        for (int i = 3; i < 6; i++) {
            g_February.add(table.getColumnModel().getColumn(i));
        }

        // Adjust UI
        header.setReorderingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class GroupableTableHeader extends JTableHeader {
    private final ColumnGroup rootGroup;
    private static final int heightOffset = 5;

    public GroupableTableHeader(TableColumnModel model) {
        super(model);
        setUI(new MyUI());
        rootGroup = new ColumnGroup("Root");
    }

    public void addGroup(ColumnGroup group) {
        rootGroup.add(group);
    }

    class MyUI extends BasicTableHeaderUI {
        @Override
        public Dimension getPreferredSize(JComponent c) {
            int height = 0;
            TableColumnModel model = header.getColumnModel();
            for (int i = 0; i < model.getColumnCount(); i++) {
                TableCellRenderer renderer = model.getColumn(i).getHeaderRenderer();
                if (renderer == null) {
                    renderer = new GroupableTableCellHeaderRenderer();
                }
                Component comp = renderer.getTableCellRendererComponent(
                        header.getTable(), model.getColumn(i).getHeaderValue(),
                        false, false, -1, i);
                height = Math.max(height, comp.getPreferredSize().height);
            }

            int nGroupsCount = getRowCount();
            if (nGroupsCount > 0) {
                for (int i = 0; i < nGroupsCount; i++) {
                    Dimension d = rootGroup.getHeaderDimensions(i);
                    if (d != null) {
                        height += d.height;
                    }
                }
            }
            return new Dimension(header.getColumnModel().getTotalColumnWidth(), height);
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            super.paint(g, c);
            int width = header.getWidth();
            int h = 0;
            for (int i = 0; i < getRowCount(); i++) {
                Rectangle clipRect = g.getClipBounds();
                Dimension d = rootGroup.getHeaderDimensions(i);
                if (d != null) {
                    if (!(clipRect.height <= h && clipRect.y >= h + d.height)) {
                        rootGroup.paintHeader(g, header.getTable(), 0, h, width - heightOffset, i == getRowCount() - 1);
                    }
                    h += d.height;
                }
            }
        }

        public int getRowCount() {
            return rootGroup.getRowCount();
        }
    }
}

class ColumnGroup {
    private String text;
    private Vector<ColumnGroup> subGroups;
    private Vector<TableColumn> columns;
    private static final int heightOffset = 5;
    private static final int columnMargin = 5;

    public ColumnGroup(String text) {
        this.text = text;
        this.subGroups = new Vector<>();
        this.columns = new Vector<>();
    }

    public void add(Object obj) {
        if (obj instanceof ColumnGroup) {
            this.subGroups.addElement((ColumnGroup) obj);
        } else if (obj instanceof TableColumn) {
            this.columns.addElement((TableColumn) obj);
        }
    }

    public int getRowCount() {
        int max = 0;
        for (ColumnGroup group : subGroups) {
            int rowCount = group.getRowCount();
            if (rowCount > max) {
                max = rowCount;
            }
        }
        return max + 1;
    }

    public Dimension getHeaderDimensions(int rowIndex) {
        if (rowIndex == 0) {
            return new Dimension(0, columnMargin + heightOffset);
        }
        int count = 1;
        for (ColumnGroup group : subGroups) {
            Dimension d = group.getHeaderDimensions(rowIndex - 1);
            if (d != null) {
                return d;
            }
            count += group.getRowCount();
        }
        return null;
    }

    public void paintHeader(Graphics g, JTable table, int x, int y, int width, boolean isLastRow) {
        Font font = table.getFont();
        g.setFont(font);

        Dimension dim = getHeaderDimensions(0);
        if (dim == null) {
            return;
        }

        // Draw background
        g.setColor(table.getTableHeader().getBackground());
        g.fillRect(x, y, width, dim.height);

        // Draw text
        g.setColor(table.getTableHeader().getForeground());
        FontMetrics fm = g.getFontMetrics();
        int stringWidth = fm.stringWidth(text);
        int stringHeight = fm.getAscent();
        int textX = x + (width - stringWidth) / 2;
        int textY = y + (dim.height + stringHeight) / 2 - 2;
        g.drawString(text, textX, textY);

        // Draw separator if not last row
        if (!isLastRow) {
            g.setColor(Color.GRAY);
            g.drawLine(x, y + dim.height - 1, x + width, y + dim.height - 1);
        }

        // Paint subgroups
        int subX = x;
        for (ColumnGroup group : subGroups) {
            int groupWidth = group.getWidth();
            group.paintHeader(g, table, subX, y + dim.height, groupWidth, isLastRow);
            subX += groupWidth;
        }
    }

    public int getWidth() {
        int width = 0;
        for (ColumnGroup group : subGroups) {
            width += group.getWidth();
        }
        for (TableColumn column : columns) {
            width += column.getWidth();
        }
        return width;
    }

    public void add(ColumnGroup group) {
        this.subGroups.addElement(group);
    }

    public void add(TableColumn column) {
        columns.addElement(column);
    }
}

class GroupableTableCellHeaderRenderer extends JLabel implements TableCellRenderer {
    private static final Border EMPTY_BORDER = BorderFactory.createEmptyBorder();

    public GroupableTableCellHeaderRenderer() {
        setHorizontalAlignment(SwingConstants.CENTER);
        setOpaque(false);
        this.setBorder(EMPTY_BORDER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "" : value.toString());
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        setFont(table.getFont());
        return this;
    }
}