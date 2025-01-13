import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.JTextField;

public class FileViewerActionListener implements ActionListener {
    private JFileChooser chooser;
    private JEditorPane pane;
    private JTextField text;
    private Object button;

    public FileViewerActionListener(JFileChooser chooser, JEditorPane pane, JTextField text, Object button) {
        this.chooser = chooser;
        this.pane = pane;
        this.text = text;
        this.button = button;
    }

    public void actionPerformed(ActionEvent event) {
        int returnVal = 0;
        if (event.getSource() == button) {
            returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                text.setText(file.getName());
                if (file != null) {
                    try {
                        pane.setPage(file.toURI().toURL());
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Error loading file: " + e.getMessage());
                    }

                } else {
                    System.err.println("Couldn't find this HTML file:" + file.getName());
                }

            } else {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        // Create instances of required objects
        JFileChooser chooser = new JFileChooser();
        JEditorPane pane = new JEditorPane();
        JTextField text = new JTextField();
        Object button = new Object();

        // Create an instance of FileViewerActionListener
        FileViewerActionListener listener = new FileViewerActionListener(chooser, pane, text, button);

        // You would typically add the listener to the button here
        // button.addActionListener(listener);
    }
}