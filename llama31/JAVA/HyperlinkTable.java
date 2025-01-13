import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.event.HyperlinkEvent;
import javax.swing.table.TableModel;

public class HyperlinkTable extends JTable {

    public HyperlinkTable(TableModel dm) {
        super(dm);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = rowAtPoint(e.getPoint());
                int col = columnAtPoint(e.getPoint());

                if (row != -1 && col != -1) {
                    Object value = getValueAt(row, col);
                    if (value instanceof JEditorPane) {
                        JEditorPane editor = (JEditorPane) value;
                        HyperlinkEvent linkEvent = new HyperlinkEvent(editor, HyperlinkEvent.EventType.ACTIVATED, editor.getHyperlink(e.getPoint()));
                        if (linkEvent.getURL() != null) {
                            // Process the hyperlink here
                            try {
                                Desktop.getDesktop().browse(linkEvent.getURL().toURI());
                            } catch (Exception ex) {
                                // Handle exception
                                System.out.println("Error: " + ex.getMessage());
                            }
                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        // Create a table model with a column of JEditorPanes
        TableModel model = new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {new JEditorPane("http://www.google.com")}
            },
            new String [] {
                "Hyperlink"
            }
        );

        // Create a new instance of HyperlinkTable
        HyperlinkTable table = new HyperlinkTable(model);

        // Create a JFrame to display the table
        javax.swing.JFrame frame = new javax.swing.JFrame();
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new javax.swing.JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
    }
}