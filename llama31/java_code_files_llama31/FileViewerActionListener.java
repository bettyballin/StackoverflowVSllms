/*
 * Decompiled with CFR 0.152.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FileViewerActionListener
implements ActionListener {
    private JFileChooser chooser;
    private JEditorPane pane;
    private JTextField text;
    private Object button;

    public FileViewerActionListener(JFileChooser jFileChooser, JEditorPane jEditorPane, JTextField jTextField, Object object) {
        this.chooser = jFileChooser;
        this.pane = jEditorPane;
        this.text = jTextField;
        this.button = object;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n = 0;
        if (actionEvent.getSource() == this.button) {
            n = this.chooser.showOpenDialog(null);
            if (n == 0) {
                File file = this.chooser.getSelectedFile();
                this.text.setText(file.getName());
                if (file != null) {
                    try {
                        this.pane.setPage(file.toURI().toURL());
                    }
                    catch (IOException iOException) {
                        JOptionPane.showMessageDialog(null, "Error loading file: " + iOException.getMessage());
                    }
                } else {
                    System.err.println("Couldn't find this HTML file:" + file.getName());
                }
            } else {
                System.exit(0);
            }
        }
    }

    public static void main(String[] stringArray) {
        JFileChooser jFileChooser = new JFileChooser();
        JEditorPane jEditorPane = new JEditorPane();
        JTextField jTextField = new JTextField();
        Object object = new Object();
        FileViewerActionListener fileViewerActionListener = new FileViewerActionListener(jFileChooser, jEditorPane, jTextField, object);
    }
}
