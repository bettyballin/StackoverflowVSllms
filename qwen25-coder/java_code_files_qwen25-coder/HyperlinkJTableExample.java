import java.lang.String;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HyperlinkJTableExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hyperlink JTable Example");
        Object[][] data = {
            {"<html><a href='http://www.example.com'>Test Link</a></html>"}
        };
        String[] columnNames = {"Link"};
        JTable table = new JTable(data, columnNames);

        // Custom renderer to use JEditorPane
        TableCellRenderer renderer = (table_, value, isSelected, hasFocus, row, column) -> {
            JEditorPane editorPane = new JEditorPane();
            editorPane.setEditable(false);
            editorPane.setContentType("text/html");
            editorPane.setText((String) value);

            // Add hyperlink listener to handle clicks
            editorPane.addHyperlinkListener(new HyperlinkListener() {
                public void hyperlinkUpdate(HyperlinkEvent e) {
                    if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                        try {
                            Desktop.getDesktop().browse(e.getURL().toURI());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });

            // Ensure JEditorPane gains focus
            editorPane.setRequestFocusEnabled(true);
            return editorPane;
        };

        table.setDefaultRenderer(String.class, renderer);

        // Add a mouse listener to the table to request focus on JEditorPane
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                if (row >= 0 && col >= 0) {
                    Component comp = table.prepareRenderer(renderer, row, col);
                    if (comp instanceof JEditorPane) {
                        ((JEditorPane) comp).requestFocusInWindow();
                    }
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
    }
}